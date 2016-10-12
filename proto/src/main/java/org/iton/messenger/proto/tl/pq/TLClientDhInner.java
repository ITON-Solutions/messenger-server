package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;


public class TLClientDhInner extends TLObject {
    protected byte[] nonce;
    protected byte[] serverNonce;
    protected long retryId;
    protected byte[] g_b;

    public static final int CLASS_ID = 0x6643b654;

    public TLClientDhInner(byte[] nonce, byte[] serverNonce, long retryId, byte[] g_b) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.retryId = retryId;
        this.g_b = g_b;
    }

    public TLClientDhInner() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public byte[] getServerNonce() {
        return serverNonce;
    }

    public long getRetryId() {
        return retryId;
    }

    public byte[] getG_b() {
        return g_b;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeBytes(nonce, buf);
        writeBytes(serverNonce, buf);
        writeLong(retryId, buf);
        writeTLBytes(g_b, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        nonce = readBytes(16, buf);
        serverNonce = readBytes(16, buf);
        retryId = readLong(buf);
        g_b = readTLBytes(buf);
    }
}
