package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUserForeign extends User {
    public static final int CLASS_ID = 0x75cf7a8;


    public TLUserForeign() {
    }

    public TLUserForeign(int id, String first_name, String last_name, String username, long access_hash, UserProfilePhoto photo, UserStatus status) {
        this.id          = id;
        this.first_name  = first_name;
        this.last_name   = last_name;
        this.username    = username;
        this.access_hash = access_hash;
        this.photo       = photo;
        this.status      = status;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeTLString(this.first_name, stream);
        writeTLString(this.last_name, stream);
        writeTLString(this.username, stream);
        writeLong(this.access_hash, stream);
        writeTLObject(this.photo, stream);
        writeTLObject(this.status, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id          = readInt(stream);
        this.first_name  = readTLString(stream);
        this.last_name   = readTLString(stream);
        this.username    = readTLString(stream);
        this.access_hash = readLong(stream);
        this.photo       = ((UserProfilePhoto) readTLObject(stream, context));
        this.status      = ((UserStatus) readTLObject(stream, context));
    }

    @Override
    public String toString() {
        return "userForeign#75cf7a8";
    }
}