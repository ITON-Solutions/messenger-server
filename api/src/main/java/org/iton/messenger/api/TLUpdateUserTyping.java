package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateUserTyping extends Update {
    public static final int CLASS_ID = 0x5c486927;

    public TLUpdateUserTyping() {
    }

    public TLUpdateUserTyping(int user_id, SendMessageAction action) {
        this.user_id = user_id;
        this.action  = action;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeTLObject(this.action, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = readInt(stream);
        this.action  = (SendMessageAction) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "update.userTyping#5c486927";
    }
}