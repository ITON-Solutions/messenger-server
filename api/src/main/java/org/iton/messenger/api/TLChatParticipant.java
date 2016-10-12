package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLChatParticipant extends TLObject {
    public static final int CLASS_ID = 0xc8d7493e;
    protected int user_id;
    protected int inviter_id;
    protected int date;

    public TLChatParticipant() {
    }

    public TLChatParticipant(int user_id, int inviter_id, int date) {
        this.user_id = user_id;
        this.inviter_id = inviter_id;
        this.date = date;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getInviterId() {
        return this.inviter_id;
    }

    public void setInviterId(int inviter_id) {
        this.inviter_id = inviter_id;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeInt(this.inviter_id, stream);
        writeInt(this.date, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id    = readInt(stream);
        this.inviter_id = readInt(stream);
        this.date       = readInt(stream);
    }

    @Override
    public String toString() {
        return "chatParticipant#c8d7493e";
    }
}