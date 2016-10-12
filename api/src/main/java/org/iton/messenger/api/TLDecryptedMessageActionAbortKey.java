package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readLong;
import static org.iton.messenger.core.utils.StreamingUtils.writeLong;

public class TLDecryptedMessageActionAbortKey extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xdd05ec6b;

    public TLDecryptedMessageActionAbortKey() {
    }

    public TLDecryptedMessageActionAbortKey(long exchange_id) {
        this.exchange_id = exchange_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.exchange_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.exchange_id = readLong(stream);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.AbortKey#dd05ec6b";
    }
}