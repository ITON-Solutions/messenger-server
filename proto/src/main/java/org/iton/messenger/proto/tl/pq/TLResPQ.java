package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;
import org.iton.messenger.core.TLObject;

public class TLResPQ extends TLObject {

    public static final int CLASS_ID = 0x05162463;

    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] pq;
    protected TLLongVector fingerprints;

    public TLResPQ(byte[] nonce, byte[] serverNonce, byte[] pq, TLLongVector fingerprints) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.pq = pq;
        this.fingerprints = fingerprints;
    }

    public TLResPQ() {
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

    public byte[] getPq() {
        return pq;
    }

    public void setPq(byte[] pq) {
        this.pq = pq;
    }

    public TLLongVector getFingerprints() {
        return fingerprints;
    }

    public void setFingerprints(TLLongVector fingerprints) {
        this.fingerprints = fingerprints;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeBytes(nonce, buf);
        writeBytes(serverNonce, buf);
        writeTLBytes(pq, buf);
        writeTLVector(fingerprints, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException, IOException {
        nonce = readBytes(16, buf);
        serverNonce = readBytes(16, buf);
        pq = readTLBytes(buf);
        fingerprints = readTLLongVector(buf, context);
    }

    @Override
    public String toString() {
        return "resPQ#05162463";
    }
}
