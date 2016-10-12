package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.iton.messenger.core.DeserializeException;

import static org.iton.messenger.core.utils.StreamingUtils.*;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

public class TLRequestDhParams extends TLMethod<TLServerDhParams> {

    public static final int CLASS_ID = 0xd712e4be;

    @Override
    public TLServerDhParams deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject response = context.deserializeMessage(stream);

        if (response == null) {
            throw new DeserializeException("Unable to deserialize response");
        }
        if (!(response instanceof TLServerDhParams)) {
            throw new DeserializeException("Response has incorrect type");
        }

        return (TLServerDhParams) response;
    }

    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] p;
    protected byte[] q;
    protected long fingerPrint;
    protected byte[] encryptedData;

    public TLRequestDhParams(byte[] nonce, byte[] serverNonce, byte[] p, byte[] q, long fingerPrint, byte[] encryptedData) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.p = p;
        this.q = q;
        this.fingerPrint = fingerPrint;
        this.encryptedData = encryptedData;
    }

    public TLRequestDhParams() {

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

    public byte[] getP() {
        return p;
    }

    public byte[] getQ() {
        return q;
    }

    public long getFingerPrint() {
        return fingerPrint;
    }

    public byte[] getEncryptedData() {
        return encryptedData;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeBytes(nonce, buf);
        writeBytes(serverNonce, buf);
        writeTLBytes(p, buf);
        writeTLBytes(q, buf);
        writeLong(fingerPrint, buf);
        writeTLBytes(encryptedData, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        nonce = readBytes(0x10, buf);
        serverNonce = readBytes(0x10, buf);
        p = readTLBytes(buf);
        q = readTLBytes(buf);
        fingerPrint = readLong(buf);
        encryptedData = readTLBytes(buf);
    }

    @Override
    public String toString() {
        return "req_DH_params#d712e4be";
    }
}
