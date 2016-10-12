package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDecryptedMessageActionAcceptKey extends DecryptedMessageAction {
    public static final int CLASS_ID = 0x6fe1735b;

    public TLDecryptedMessageActionAcceptKey() {
    }

    public TLDecryptedMessageActionAcceptKey(long exchange_id, byte[] g_b, long key_fingerprint) {
        this.exchange_id     = exchange_id;
        this.g_b             = g_b;
        this.key_fingerprint = key_fingerprint;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.exchange_id, stream);
        writeTLBytes(this.g_b, stream);
        writeLong(this.key_fingerprint, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.exchange_id     = readLong(stream);
        this.g_b             = readTLBytes(stream);
        this.key_fingerprint = readLong(stream);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.AcceptKey#6fe1735b";
    }
}