package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDecryptedMessageActionRequestKey extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xf3c9611b;

    public TLDecryptedMessageActionRequestKey() {
    }

    public TLDecryptedMessageActionRequestKey(long exchange_id, byte[] g_a) {
        this.exchange_id = exchange_id;
        this.g_a         = g_a;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.exchange_id, stream);
        writeTLBytes(this.g_a, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.exchange_id = readLong(stream);
        this.g_a         = readTLBytes(stream);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.RequestKey#f3c9611b";
    }
}