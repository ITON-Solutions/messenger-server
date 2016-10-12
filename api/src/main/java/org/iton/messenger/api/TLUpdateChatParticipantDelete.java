package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateChatParticipantDelete extends Update {
    public static final int CLASS_ID = 0x6e5f8c22;


    public TLUpdateChatParticipantDelete() {
    }

    public TLUpdateChatParticipantDelete(int chat_id, int user_id, int version) {
        this.chat_id = chat_id;
        this.user_id = user_id;
        this.version = version;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.chat_id, stream);
        writeInt(this.user_id, stream);
        writeInt(this.version, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.chat_id = readInt(stream);
        this.user_id = readInt(stream);
        this.version = readInt(stream);
    }

    public String toString() {
        return "updateChatParticipantDelete#6e5f8c22";
    }
}
