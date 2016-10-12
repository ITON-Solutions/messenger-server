package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readBytes;
import static org.iton.messenger.core.utils.StreamingUtils.writeBytes;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

public abstract class TLClientDhResult extends TLObject {
    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] newNonceHash;

    protected TLClientDhResult(byte[] nonce, byte[] serverNonce, byte[] newNonceHash) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.newNonceHash = newNonceHash;
    }


    public TLClientDhResult() {

    }

    public byte[] getNonce() {
        return nonce;
    }

    public byte[] getServerNonce() {
        return serverNonce;
    }

    public byte[] getNewNonceHash() {
        return newNonceHash;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeBytes(nonce, stream);
        writeBytes(serverNonce, stream);
        writeBytes(newNonceHash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        nonce = readBytes(16, buf);
        serverNonce = readBytes(16, buf);
        newNonceHash = readBytes(16, buf);
    }
}
