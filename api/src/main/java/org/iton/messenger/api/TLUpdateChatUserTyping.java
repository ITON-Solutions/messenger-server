package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateChatUserTyping extends Update {
    public static final int CLASS_ID = 0x9a65ea1f;

    public TLUpdateChatUserTyping() {
    }

    public TLUpdateChatUserTyping(int chat_id, int user_id, SendMessageAction action) {
        this.chat_id = chat_id;
        this.user_id = user_id;
        this.action  = action;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.chat_id, stream);
        writeInt(this.user_id, stream);
        writeTLObject(this.action, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.chat_id = readInt(stream);
        this.user_id = readInt(stream);
        this.action  = (SendMessageAction) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "update.chatUserTyping#9a65ea1f";
    }
}