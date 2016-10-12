package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDecryptedMessageActionReadMessages extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xc4f40be;

    public TLDecryptedMessageActionReadMessages() {
    }

    public TLDecryptedMessageActionReadMessages(TLLongVector random_ids) {
        this.random_ids = random_ids;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.random_ids, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.random_ids = readTLLongVector(stream, context);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.ReadMessages#c4f40be";
    }
}