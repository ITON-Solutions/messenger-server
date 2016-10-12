package org.iton.messenger.server.proto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.server.TLProtoContext;
import org.iton.messenger.server.auth.MTAuthHandler;
import org.iton.messenger.server.auth.MTAuthEncoder;
import org.iton.messenger.server.message.MTMessageEncoder;
import org.iton.messenger.server.message.MTMessageHandler;
import org.iton.messenger.server.services.db.DBService;
import org.iton.messenger.server.services.session.MTSessionManager;
import org.iton.messenger.model.engines.ITelegramEngine;
import org.iton.messenger.model.entities.ETAuthorization;
import org.iton.messenger.model.entities.ETUser;
import org.iton.messenger.server.services.session.IMTSessionManager;
import org.iton.messenger.server.session.MTSession;
import org.iton.messenger.proto.tl.MTMessage;

import org.iton.messenger.proto.util.TimeUtil;
import org.iton.messenger.core.TLObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import static org.iton.messenger.proto.secure.CryptoUtils.*;

/**
 * Created by ITON on 9/2/14.
 */
public class MTMessageDecoder extends ByteToMessageDecoder {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTMessageDecoder.class);

    private static final TLProtoContext context    = new TLProtoContext();
    private static final ITelegramEngine engine    = DBService.getInstance().getEngine();
    private static final IMTSessionManager manager = MTSessionManager.getInstance();

    private static final long EMPTY_AUTH_KEY_ID = 0L;

    private static final long REJECTED_AFTER  = 300000;
    private static final long REJECTED_BEFORE = 30000;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        ChannelPipeline pipeline = ctx.pipeline();

        long authKeyId = readLong(in);

        if(authKeyId == EMPTY_AUTH_KEY_ID) {

            long messageId   = readLong(in);
            int  length      = readInt(in);
            ByteBuf data     = in.readBytes(length);
            TLObject message = context.deserializeMessage(data);

            if(pipeline.get(MTMessageHandler.class) != null) {
                pipeline.remove(MTMessageHandler.class);
            }

            if(pipeline.get(MTMessageEncoder.class) != null) {
                pipeline.remove(MTMessageEncoder.class);
            }

            if(pipeline.get(MTAuthHandler.class) == null) {
                pipeline.addLast(new MTAuthHandler());
            }

            if(pipeline.get(MTAuthEncoder.class) == null) {
                pipeline.addLast(new MTAuthEncoder());
            }
            ctx.fireChannelRead(message);
        } else {

            MTMessage message = decrypt(ctx, in, longToBytes(authKeyId), in.capacity());

            if(pipeline.get(MTAuthHandler.class) != null) {
                pipeline.remove(MTAuthHandler.class);
            }

            if(pipeline.get(MTAuthEncoder.class) != null) {
                pipeline.remove(MTAuthEncoder.class);
            }

            if(pipeline.get(MTMessageHandler.class) == null) {
                pipeline.addLast(new MTMessageHandler());
            }

            if(pipeline.get(MTMessageEncoder.class) == null) {
                pipeline.addLast(new MTMessageEncoder());
            }

            ctx.fireChannelRead(message);
        }
    }

    protected MTMessage decrypt(ChannelHandlerContext ctx, ByteBuf buf, byte[] authKeyId, int length) throws Exception {

        byte[] authKey;
        ETUser user = null;

        MTSession session = manager.getMTSession(ctx.channel());

        if (session == null) {
            ETAuthorization auth = engine.getAuthorizationModel().findById(authKeyId);
            authKey = auth.getDHKey();
            user    = auth.getUser();
        }
        else {
            authKey = session.getAuthKey();
            log.debug("Acquiring authorization key form MTSession: " + session.toString() + (session.getUser() == null ? "" : " user : " + session.getUser().getId()));
        }

        byte[] msgKey = readBytes(0x10, buf);

        byte[] sha1_a = SHA1(msgKey, substring(authKey, 0, 0x20));
        byte[] sha1_b = SHA1(substring(authKey, 0x20, 0x10), msgKey, substring(authKey, 0x30, 0x10));
        byte[] sha1_c = SHA1(substring(authKey, 0x40, 0x20), msgKey);
        byte[] sha1_d = SHA1(msgKey, substring(authKey, 0x60, 0x20));

        byte[] aesKey = concat(substring(sha1_a, 0, 0x8), substring(sha1_b, 0x8, 0xC), substring(sha1_c, 0x4, 0xC));
        byte[] aesIv  = concat(substring(sha1_a, 0x8, 0xC), substring(sha1_b, 0, 0x8), substring(sha1_c, 0x10, 0x4), substring(sha1_d, 0, 0x8));

        int totalLen = length - authKeyId.length - msgKey.length;

        byte[] encrypted = readBytes(totalLen, buf);
        byte[] decrypted = AES256IGEDecrypt(encrypted, aesIv, aesKey);

        ByteBuf body     = Unpooled.copiedBuffer(decrypted);
        byte[] salt      = readBytes(0x8, body);
        byte[] sessionId = readBytes(0x8, body);
        long messageId   = readLong(body);
        int seqNo        = readInt(body);
        int msg_len      = readInt(body);

        int bodySize = totalLen - 0x20;

        if (msg_len % 0x4 != 0) {
            throw new SecurityException("Invalid message length modulo: msg_length % 4");
        }

        if (msg_len > bodySize) {
            throw new SecurityException("Invalid message length msg_length > body_size");
        }

        if (msg_len - bodySize > 0xF) {
            throw new SecurityException("Invalid message length msg_length - body_size > 0xF");
        }

        byte[] data = readBytes(msg_len, body);

        byte[] checkHash = optimizedSHA(salt, sessionId, messageId, seqNo, msg_len, data, msg_len);

        if (!arrayEq(substring(checkHash, 0x4, 0x10), msgKey)) {
            throw new SecurityException();
        }

        // Check if sessionId is valid
        if(manager.getMTSession(ctx.channel()) != null && !arrayEq(sessionId, manager.getMTSession(ctx.channel()).getSessionId())) {
            log.error("Session Id has been modified");
            manager.getMTSession(ctx.channel()).setSessionId(sessionId);
        }

        long deviceTime = TimeUtil.getMilliseconds(messageId);
        long serverTime = System.currentTimeMillis();

        if (deviceTime - REJECTED_BEFORE > serverTime){
            // Message rejected if its 30 sec younger
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' h:mm a");
            log.error("Device time : " + format.format(deviceTime));
            log.error("Server time : " + format.format(serverTime));
            throw new SecurityException("Incorrect message time: is too young ");
        }

        if (deviceTime + REJECTED_AFTER < serverTime){
            // Message rejected if its 300 sec old
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' h:mm a");
            log.error("Device time : " + format.format(deviceTime));
            log.error("Server time : " + format.format(serverTime));
            throw new SecurityException("Incorrect message time: is too old");
        }

        if (session == null) {
            manager.addMTSession(ctx.channel(), new MTSession(authKeyId, authKey, salt, sessionId, user));

            // Close all other inactive channels
            List<Channel> channels = manager.getChannels(manager.getMTSession(ctx.channel()).getSessionId());
            channels.stream().filter(channel -> channel != ctx.channel()).forEach(ChannelOutboundInvoker::close);

            log.debug("Create new Session: " + manager.getMTSession(ctx.channel()).toString() + " channel: [id: 0x" + ctx.channel().id() + "]");
        }

        return new MTMessage(messageId, seqNo, data, data.length);
    }

    private byte[] optimizedSHA(byte[] salt, byte[] session, long messageId, int seqNo, int len, byte[] data, int datalen) {
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(salt);
            crypt.update(session);
            crypt.update(longToBytes(messageId));
            crypt.update(intToBytes(seqNo));
            crypt.update(intToBytes(len));
            crypt.update(data, 0, datalen);
            return crypt.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new SecurityException("No such algorithm exception");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        log.error("Close channel: " + ctx.channel() + " Exit with error: " + cause.getMessage());
        ctx.close();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }
}
