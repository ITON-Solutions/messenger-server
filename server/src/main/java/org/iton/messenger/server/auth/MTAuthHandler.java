package org.iton.messenger.server.auth;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import org.iton.messenger.proto.tl.pq.*;
import org.iton.messenger.server.TLProtoContext;
import org.iton.messenger.server.secure.DHServer;
import org.iton.messenger.server.secure.RSAServer;
import org.iton.messenger.model.engines.ITelegramEngine;
import org.iton.messenger.model.entities.ETAuthorization;
import org.iton.messenger.server.services.db.DBService;
import org.iton.messenger.proto.TransportSecurityException;
import org.iton.messenger.proto.secure.Entropy;
import org.iton.messenger.proto.tl.TLMessagesAck;
import org.iton.messenger.proto.util.TimeUtil;
import org.iton.messenger.core.TLLongVector;
import org.iton.messenger.core.TLObject;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.stream.Collectors;

import static org.iton.messenger.core.utils.StreamingUtils.readBytes;
import static org.iton.messenger.core.utils.StreamingUtils.skipBytes;
import static org.iton.messenger.proto.secure.CryptoUtils.*;

/**
 * Created by ITON on 9/2/14.
 */
public class MTAuthHandler extends SimpleChannelInboundHandler<TLObject> {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTAuthHandler.class);

    private static final TLProtoContext context  = new TLProtoContext();
    private static final ITelegramEngine engine = DBService.getInstance().getEngine();

    private static final byte DH_KEY_OK     = 1;
    private static final byte DH_KEY_RETRY  = 2;
    private static final byte DH_KEY_FAILED = 3;

    private byte[] dh_power;
    private byte[] aes_iv;
    private byte[] aes_key;

    private byte[] nonce;
    private byte[] new_nonce;
    private byte[] server_nonce;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TLObject message) throws Exception {

        switch (message.getClassId()) {
            case TLRequestPQ.CLASS_ID:
                log.debug("Request req_pq");
                resPQ(ctx, (TLRequestPQ) message);
                break;
            case TLRequestDhParams.CLASS_ID:
                log.debug("Request req_dh_params");
                serverDhParams(ctx, (TLRequestDhParams) message);
                break;
            case TLClientDhParams.CLASS_ID:
                log.debug("Request req_set_client_dh_params");
                dhGenResult(ctx, (TLClientDhParams) message);
                break;
            case TLMessagesAck.CLASS_ID:
                log.debug("Request messages_ack");
                ack((TLMessagesAck) message);
                break;
            default:
                log.debug("Not recognized proto message: " + Integer.toHexString(message.getClassId()));
        }
    }

    private void ack(TLMessagesAck ack) {

        String result = ack.getMessages().stream()
                .map(item -> Long.toString(TimeUtil.getMilliseconds(item)))
                .collect(Collectors.joining(", "));
        log.debug("message_ack: " + result);
    }

    private void resPQ(ChannelHandlerContext ctx, TLRequestPQ request) throws IOException {

        nonce        = request.getNonce();
        server_nonce = Entropy.generateSeed(0x10);

        BigInteger p = BigInteger.probablePrime(0x1F, new SecureRandom());
        BigInteger q = p.nextProbablePrime();
        byte[] pq    = p.multiply(q).toByteArray();

        // Prepare response
        TLLongVector fingerprints = new TLLongVector();
        fingerprints.add(RSAServer.RSA_KEY.getFingerprint().longValue());

        TLResPQ response = new TLResPQ(nonce, server_nonce, pq, fingerprints);

        ctx.channel().writeAndFlush(response);
    }

    private void serverDhParams(ChannelHandlerContext ctx, TLRequestDhParams request) throws IOException {

        byte[] encrypted = request.getEncryptedData();
        byte[] message   = RSADecrypt(encrypted, RSAServer.RSA_KEY.getModulus(), RSAServer.RSA_KEY.getPrivateExponent());

        ByteBuf buf = Unpooled.copiedBuffer(message);
        // TODO Check aligned to 0xFF indeed 0x100
        skipBytes(message.length - 0xFF, buf);

        ByteBuf hash      = buf.readBytes(0x14);
        TLPQInner pqInner = (TLPQInner) context.deserializeMessage(buf);
        byte[] p          = pqInner.getP();
        byte[] q          = pqInner.getQ();
        byte[] pq         = pqInner.getPq();


        if(!arrayEq(nonce, pqInner.getNonce())){
            throw new TransportSecurityException("Invalid nonce in request DH parameters");
        }

        if(!arrayEq(server_nonce, pqInner.getServerNonce())){
            throw new TransportSecurityException("Invalid server_nonce request DH parameters");
        }

        new_nonce = pqInner.getNewNonce();

        aes_key = concat(SHA1(new_nonce, server_nonce), substring(SHA1(server_nonce, new_nonce), 0, 0xC));
        aes_iv  = concat(concat(substring(SHA1(server_nonce, new_nonce), 0xC, 0x8), SHA1(new_nonce, new_nonce)), substring(new_nonce, 0, 0x4));

        // Prepare response
        dh_power = Entropy.generateSeed(0x100);
        byte[] g_a = DHServer.getG_a(dh_power);

        TLServerDhInner dhInner = new TLServerDhInner(nonce, server_nonce, DHServer.DH_KEY.getG(), DHServer.DH_KEY.getDhPrime(), g_a, (int)(System.currentTimeMillis() / 1000));

        byte[] inner = dhInner.serialize();

        // Need to encrypt in blocks of 0x10 length
        byte[] answer = AES256IGEEncrypt(align(concat(SHA1(inner), inner), 0x10), aes_iv, aes_key);

        TLServerDhParamsOk response = new TLServerDhParamsOk(nonce, server_nonce, answer);

        ctx.channel().writeAndFlush(response);
    }

    private void dhGenResult(ChannelHandlerContext ctx, TLClientDhParams request) throws IOException {

        byte[] encrypted = request.getEncrypted();

        if(!arrayEq(nonce, request.getNonce())){
            throw new TransportSecurityException("Invalid nonce in request set client DH parameters");
        }

        if(!arrayEq(server_nonce, request.getServerNonce())){
            throw new TransportSecurityException("Invalid server_nonce request set client DH parameters");
        }

        byte[] answer = AES256IGEDecrypt(encrypted, aes_iv, aes_key);


        ByteBuf buf = Unpooled.copiedBuffer(answer);
        byte[] hash = readBytes(0x14, buf);
        TLClientDhInner dhInner = (TLClientDhInner) context.deserializeMessage(buf);

        if (!arrayEq(hash, SHA1(dhInner.serialize()))){
            throw new TransportSecurityException("Invalid serialization");
        }

        if(!arrayEq(nonce, dhInner.getNonce())){
            throw new TransportSecurityException("Invalid nonce in request set client DH parameters");
        }

        if(!arrayEq(server_nonce, dhInner.getServerNonce())){
            throw new TransportSecurityException("Invalid server_nonce request set client DH parameters");
        }

        byte retry = (byte) dhInner.getRetryId();
        byte[] g_b = dhInner.getG_b();

        BigInteger key   = loadBigInt(g_b).modPow(loadBigInt(dh_power), loadBigInt(DHServer.DH_KEY.getDhPrime()));
        byte[] authKey   = alignKeyZero(fromBigInt(key), 0x100);
        byte[] authHash  = substring(SHA1(authKey), 0x0, 0x8);
        byte[] authKeyId = substring(SHA1(authKey), 0xC, 0x8);

        // Store authorization key
        ETAuthorization auth = new ETAuthorization(ToHex(authKeyId), authKey, null);
        engine.getAuthorizationModel().save(auth);

        TLClientDhResultOk response = new TLClientDhResultOk(nonce, server_nonce, substring(SHA1(new_nonce, new byte[]{DH_KEY_OK}, authHash), 0x4, 0x10));

        ctx.channel().writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        log.error("Close channel. Exit with error: " , cause);
        ctx.close();
    }
}
