package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLLongVector;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLVector;

public class TLDecryptedMessageActionScreenshotMessages extends DecryptedMessageAction {
    public static final int CLASS_ID = 0x8ac1f475;

    public TLDecryptedMessageActionScreenshotMessages() {
    }

    public TLDecryptedMessageActionScreenshotMessages(TLLongVector random_ids) {
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
        return "decrypted.message.action.ScreenshotMessages#8ac1f475";
    }
}