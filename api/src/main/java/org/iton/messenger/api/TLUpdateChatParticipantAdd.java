package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateChatParticipantAdd extends Update {
    public static final int CLASS_ID = 0x3a0eeb22;


    public TLUpdateChatParticipantAdd() {
    }

    public TLUpdateChatParticipantAdd(int chat_id, int user_id, int inviter_id, int version) {
        this.chat_id    = chat_id;
        this.user_id    = user_id;
        this.inviter_id = inviter_id;
        this.version    = version;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.chat_id, stream);
        writeInt(this.user_id, stream);
        writeInt(this.inviter_id, stream);
        writeInt(this.version, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.chat_id    = readInt(stream);
        this.user_id    = readInt(stream);
        this.inviter_id = readInt(stream);
        this.version    = readInt(stream);
    }

    public String toString() {
        return "update.chatParticipantAdd#3a0eeb22";
    }
}
