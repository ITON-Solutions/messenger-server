package org.iton.messenger.proto.tl.pq;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLServerDhInner extends TLObject {
    public static final int CLASS_ID = 0xb5890dba;

    protected byte[] nonce;
    protected byte[] serverNonce;
    protected int g;
    protected byte[] dhPrime;
    protected byte[] g_a;
    protected int serverTime;

    public TLServerDhInner(byte[] nonce, byte[] serverNonce, int g, byte[] dhPrime, byte[] g_a, int serverTime) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.g = g;
        this.dhPrime = dhPrime;
        this.g_a = g_a;
        this.serverTime = serverTime;
    }

    public TLServerDhInner() {

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

    public int getG() {
        return g;
    }

    public byte[] getDhPrime() {
        return dhPrime;
    }

    public byte[] getG_a() {
        return g_a;
    }

    public int getServerTime() {
        return serverTime;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeBytes(nonce, buf);
        writeBytes(serverNonce, buf);
        writeInt(g, buf);
        writeTLBytes(dhPrime, buf);
        writeTLBytes(g_a, buf);
        writeInt(serverTime, buf);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        nonce       = readBytes(0x10, stream);
        serverNonce = readBytes(0x10, stream);
        g           = readInt(stream);
        dhPrime     = readTLBytes(stream);
        g_a         = readTLBytes(stream);
        serverTime  = readInt(stream);
    }
}
