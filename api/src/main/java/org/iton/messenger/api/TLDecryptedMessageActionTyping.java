package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDecryptedMessageActionTyping extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xccb27641;

    public TLDecryptedMessageActionTyping() {
    }

    public TLDecryptedMessageActionTyping(SendMessageAction action) {
        this.action = action;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.action, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.action = (SendMessageAction) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.Typing#ccb27641";
    }
}