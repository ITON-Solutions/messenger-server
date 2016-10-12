package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLChatParticipantsForbidden extends ChatParticipants {
    public static final int CLASS_ID = 0xfd2bb8a;


    public TLChatParticipantsForbidden() {
    }

    public TLChatParticipantsForbidden(int chat_id) {
        this.chat_id      = chat_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getChatId() {
        return this.chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.chat_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.chat_id      = readInt(stream);
    }

    @Override
    public String toString() {
        return "chatParticipantsForbidden#fd2bb8a";
    }
}