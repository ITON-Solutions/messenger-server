package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLChatParticipants extends ChatParticipants {
    public static final int CLASS_ID = 0x7841b415;


    public TLChatParticipants() {
    }

    public TLChatParticipants(int chat_id, int admin_id, TLVector<TLChatParticipant> participants, int version) {
        this.chat_id      = chat_id;
        this.admin_id     = admin_id;
        this.participants = participants;
        this.version      = version;
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

    public int getAdminId() {
        return this.admin_id;
    }

    public void setAdminId(int admin_id) {
        this.admin_id = admin_id;
    }

    public TLVector<TLChatParticipant> getParticipants() {
        return this.participants;
    }

    public void setParticipants(TLVector<TLChatParticipant> participants) {
        this.participants = participants;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.chat_id, stream);
        writeInt(this.admin_id, stream);
        writeTLVector(this.participants, stream);
        writeInt(this.version, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.chat_id      = readInt(stream);
        this.admin_id     = readInt(stream);
        this.participants = readTLVector(stream, context);
        this.version      = readInt(stream);
    }

    @Override
    public String toString() {
        return "chatParticipants#7841b415";
    }
}