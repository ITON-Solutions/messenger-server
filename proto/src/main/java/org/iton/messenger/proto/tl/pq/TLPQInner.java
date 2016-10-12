package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;


public class TLPQInner extends TLObject {
    public static final int CLASS_ID = 0x83c95aec;

    protected byte[] pq;
    protected byte[] p;
    protected byte[] q;
    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] newNonce;

    public TLPQInner(byte[] pq, byte[] p, byte[] q, byte[] nonce, byte[] serverNonce, byte[] newNonce) {
        this.pq = pq;
        this.p = p;
        this.q = q;
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.newNonce = newNonce;
    }

    public TLPQInner() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public byte[] getPq() {
        return pq;
    }

    public byte[] getP() {
        return p;
    }

    public byte[] getQ() {
        return q;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public byte[] getServerNonce() {
        return serverNonce;
    }

    public byte[] getNewNonce() {
        return newNonce;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLBytes(pq, stream);
        writeTLBytes(p, stream);
        writeTLBytes(q, stream);
        writeBytes(nonce, stream);
        writeBytes(serverNonce, stream);
        writeBytes(newNonce, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        pq = readTLBytes(stream);
        p = readTLBytes(stream);
        q = readTLBytes(stream);
        nonce = readBytes(16, stream);
        serverNonce = readBytes(16, stream);
        newNonce = readBytes(32, stream);
    }
}
