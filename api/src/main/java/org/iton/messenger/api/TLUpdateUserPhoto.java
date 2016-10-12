package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateUserPhoto extends Update {
    public static final int CLASS_ID = 0x95313b0c;


    public TLUpdateUserPhoto() {
    }

    public TLUpdateUserPhoto(int user_id, int date, UserProfilePhoto photo, boolean previous) {
        this.user_id  = user_id;
        this.date     = date;
        this.photo    = photo;
        this.previous = previous;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }



    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeInt(this.date, stream);
        writeTLObject(this.photo, stream);
        writeTLBool(this.previous, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id  = readInt(stream);
        this.date     = readInt(stream);
        this.photo    = (UserProfilePhoto) readTLObject(stream, context);
        this.previous = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "update.userPhoto#95313b0c";
    }
}