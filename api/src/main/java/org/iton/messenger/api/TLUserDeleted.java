package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUserDeleted extends User {
    public static final int CLASS_ID = 0xd6016d7a;


    public TLUserDeleted() {
    }

    public TLUserDeleted(int id, String first_name, String last_name, String username) {
        this.id          = id;
        this.first_name  = first_name;
        this.last_name   = last_name;
        this.username    = username;
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
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id          = readInt(stream);
        this.first_name  = readTLString(stream);
        this.last_name   = readTLString(stream);
        this.username    = readTLString(stream);
    }

    @Override
    public String toString() {
        return "userDeleted#d6016d7a";
    }
}