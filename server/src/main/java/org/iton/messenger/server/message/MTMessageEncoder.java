package org.iton.messenger.server.message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.server.services.session.IMTSessionManager;
import org.iton.messenger.server.services.session.MTSessionManager;
import org.iton.messenger.server.session.MTSession;
import org.iton.messenger.proto.tl.MTMessage;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import static org.iton.messenger.proto.secure.CryptoUtils.*;

/**
 * Created by ITON on 9/12/14.
 */
public class MTMessageEncoder extends MessageToByteEncoder<MTMessage> {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTMessageEncoder.class);
    private static final IMTSessionManager manager = MTSessionManager.getInstance();

    private boolean confirm = false;

    @Override
    protected void encode(ChannelHandlerContext ctx, MTMessage message, ByteBuf out) throws Exception {

        if(message == null){
            return;
        }

        MTSession session = manager.getMTSession(ctx.channel());

        // 1. messsage
        ByteBuf body = Unpooled.buffer();
        writeBytes(session.getServerSalt(), body);
        writeBytes(session.getSessionId(), body);
        writeLong(message.getMessageId(), body);
        writeInt(message.getSeqNo(), body);

        byte[] content = message.getContent();

        writeInt(content.length, body);
        writeBytes(content, body);

        // 2. encrypt message
        byte[] innerData = readBytes(content.length + 0x20, body);
        byte[] msgKey    = substring(SHA1(innerData), 0x4, 0x10);
        int fastConfirm  = readInt(SHA1(innerData)) | (1 << 0x1F);

        ByteBuf result = Unpooled.buffer();
        writeBytes(session.getAuthKeyId(), result);
        writeBytes(msgKey, result);

        byte[] authKey = session.getAuthKey();

        byte[] sha1_a = SHA1(msgKey, substring(authKey, 0x8, 0x20));
        byte[] sha1_b = SHA1(substring(authKey, 0x28, 0x10), msgKey, substring(authKey, 0x38, 0x10));
        byte[] sha1_c = SHA1(substring(authKey, 0x48, 0x20), msgKey);
        byte[] sha1_d = SHA1(msgKey, substring(authKey, 0x68, 0x20));

        byte[] aesKey = concat(substring(sha1_a, 0, 0x8), substring(sha1_b, 0x8, 0xC), substring(sha1_c, 0x4, 0xC));
        byte[] aesIv  = concat(substring(sha1_a, 0x8, 0xC), substring(sha1_b, 0, 0x8), substring(sha1_c, 0x10, 0x4), substring(sha1_d, 0, 0x8));

        byte[] encoded = AES256IGEEncrypt(align(innerData, 0x10), aesIv, aesKey);

        writeBytes(encoded, result);

        // 3. write entire payload
        byte[] data = readBytes(encoded.length + 0x18, result);
        int length  = data.length;

        if (confirm)
        {
            if (length / 4 >= 0x7F)
            {
                int len = length / 4;
                out.writeByte(0xFF);
                out.writeByte(len & 0xFF);
                out.writeByte((len >> 0x8) & 0xFF);
                out.writeByte((len >> 0x10) & 0xFF);
            }
            else
            {
                out.writeByte((length / 4) | (1 << 7));
            }
        }
        else
        {
            if (length / 4 >= 0x7F)
            {
                int len = length / 4;
                out.writeByte(0x7F);
                out.writeByte(len & 0xFF);
                out.writeByte((len >> 0x8) & 0xFF);
                out.writeByte((len >> 0x10) & 0xFF);
            }
            else
            {
                out.writeByte(length / 4);
            }
        }

        writeBytes(data, out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        log.error("Close channel: " + ctx.channel() + " Exit with error: " + cause.getCause());
        ctx.close();
    }
}
