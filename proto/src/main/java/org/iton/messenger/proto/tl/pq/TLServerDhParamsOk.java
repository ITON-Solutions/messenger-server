package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import org.iton.messenger.core.TLContext;

public class TLServerDhParamsOk extends TLServerDhParams {

    public static final int CLASS_ID = 0xd0e8075c;

    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] encryptedAnswer;

    public TLServerDhParamsOk(byte[] nonce, byte[] serverNonce, byte[] encryptedAnswer) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.encryptedAnswer = encryptedAnswer;
    }

    public TLServerDhParamsOk() {

    }

    public byte[] getNonce() {
        return nonce;
    }

    public byte[] getServerNonce() {
        return serverNonce;
    }

    public byte[] getEncryptedAnswer() {
        return encryptedAnswer;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeBytes(nonce, buf);
        writeBytes(serverNonce, buf);
        writeTLBytes(encryptedAnswer, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        nonce = readBytes(16, buf);
        serverNonce = readBytes(16, buf);
        encryptedAnswer = readTLBytes(buf);
    }

    @Override
    public String toString() {
        return "server_DH_params_ok#d0e8075c";
    }
}
