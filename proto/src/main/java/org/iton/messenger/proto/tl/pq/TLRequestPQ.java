package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.iton.messenger.core.DeserializeException;
import static org.iton.messenger.core.utils.StreamingUtils.*;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

public class TLRequestPQ extends TLMethod<TLResPQ> {

    public static final int CLASS_ID = 0x60469778;

    protected byte[] nonce;

    public TLRequestPQ(byte[] nonce) {
        if (nonce == null || nonce.length != 0x10) {
            throw new IllegalArgumentException("nonce might be not null and 16 bytes length");
        }
        this.nonce = nonce;
    }

    public TLRequestPQ() {

    }

    @Override
    public TLResPQ deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject response = context.deserializeMessage(buf);
        if (response == null) {
            throw new DeserializeException("Unable to deserialize response");
        }
        if (!(response instanceof TLResPQ)) {
            throw new DeserializeException("Response has incorrect type");
        }

        return (TLResPQ) response;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public void setNonce(byte[] nonce) {
        if (nonce == null || nonce.length != 0x10) {
            throw new IllegalArgumentException("nonce might be not null and 16 bytes length");
        }
        this.nonce = nonce;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeBytes(nonce, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        nonce = readBytes(0x10, buf);
    }

    @Override
    public String toString() {
        return "req_pq#60469778";
    }
}
