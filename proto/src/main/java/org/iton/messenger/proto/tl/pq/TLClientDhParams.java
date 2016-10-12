package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.iton.messenger.core.DeserializeException;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

public class TLClientDhParams extends TLMethod<TLClientDhResult> {

    public static final int CLASS_ID = 0xf5045f1f;

    @Override
    public TLClientDhResult deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject response = context.deserializeMessage(buf);
        if (response == null) {
            throw new DeserializeException("Unable to deserialize response");
        }
        if (!(response instanceof TLClientDhResult)) {
            throw new DeserializeException("Response has incorrect type");
        }
        return (TLClientDhResult) response;
    }

    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] encrypted;

    public TLClientDhParams(byte[] nonce, byte[] serverNonce, byte[] encrypted) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.encrypted = encrypted;
    }

    public TLClientDhParams() {

    }

    public byte[] getNonce() {
        return nonce;
    }

    public byte[] getServerNonce() {
        return serverNonce;
    }

    public byte[] getEncrypted() {
        return encrypted;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeBytes(nonce, stream);
        writeBytes(serverNonce, stream);
        writeTLBytes(encrypted, stream);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        nonce = readBytes(16, buf);
        serverNonce = readBytes(16, buf);
        encrypted = readTLBytes(buf);
    }

    @Override
    public String toString() {
        return "set_client_DH_params#f5045f1f";
    }
}