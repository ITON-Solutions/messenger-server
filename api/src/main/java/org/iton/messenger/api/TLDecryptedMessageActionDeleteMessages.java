package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLLongVector;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLVector;

public class TLDecryptedMessageActionDeleteMessages extends DecryptedMessageAction {
    public static final int CLASS_ID = 0x65614304;

    public TLDecryptedMessageActionDeleteMessages() {
    }

    public TLDecryptedMessageActionDeleteMessages(TLLongVector random_ids) {
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
        return "decrypted.message.action.DeleteMessages#65614304";
    }
}