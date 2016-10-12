package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import org.iton.messenger.core.TLContext;

public class TLServerDhParamsFailure extends TLServerDhParams {

    public static final int CLASS_ID = 0x79cb045d;

    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] newNonceHash;

    public TLServerDhParamsFailure(byte[] nonce, byte[] serverNonce, byte[] newNonceHash) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.newNonceHash = newNonceHash;
    }

    public TLServerDhParamsFailure() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }

    public byte[] getServerNonce() {
        return serverNonce;
    }

    public void setServerNonce(byte[] serverNonce) {
        this.serverNonce = serverNonce;
    }

    public byte[] getNewNonceHash() {
        return newNonceHash;
    }

    public void setNewNonceHash(byte[] newNonceHash) {
        this.newNonceHash = newNonceHash;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeBytes(nonce, buf);
        writeBytes(serverNonce, buf);
        writeBytes(newNonceHash, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        nonce = readBytes(16, buf);
        serverNonce = readBytes(16, buf);
        newNonceHash = readBytes(16, buf);
    }

    @Override
    public String toString() {
        return "server_DH_params_fail#79cb045d";
    }
}
