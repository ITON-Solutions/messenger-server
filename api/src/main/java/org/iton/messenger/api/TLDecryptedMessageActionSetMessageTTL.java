package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDecryptedMessageActionSetMessageTTL extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xa1733aec;

    public TLDecryptedMessageActionSetMessageTTL() {
    }

    public TLDecryptedMessageActionSetMessageTTL(int ttl_seconds) {
        this.ttl_seconds = ttl_seconds;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.ttl_seconds, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.ttl_seconds = readInt(stream);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.SetMessageTTL#a1733aec";
    }
}