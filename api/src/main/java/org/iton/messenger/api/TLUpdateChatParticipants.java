package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateChatParticipants extends Update {
    public static final int CLASS_ID = 0x7761198;


    public TLUpdateChatParticipants() {
    }

    public TLUpdateChatParticipants(ChatParticipants participants) {
        this.participants = participants;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream)  throws IOException {
        writeTLObject(this.participants, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.participants = (ChatParticipants) readTLObject(stream, context);
    }

    public String toString() {
        return "update.chatParticipants#7761198";
    }
}
