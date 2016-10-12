package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.updates.Updates;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdatesCombined extends Updates {
    public static final int CLASS_ID = 0x725b04c3;

    public TLUpdatesCombined() {
    }

    public TLUpdatesCombined(TLVector<Update> updates, TLVector<User> users, TLVector<Chat> chats, int date, int seq_start, int seq) {
        this.updates   = updates;
        this.users     = users;
        this.chats     = chats;
        this.date      = date;
        this.seq_start = seq_start;
        this.seq       = seq;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.updates, stream);
        writeTLVector(this.users, stream);
        writeTLVector(this.chats, stream);
        writeInt(this.date, stream);
        writeInt(this.seq_start, stream);
        writeInt(this.seq, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.updates   = readTLVector(stream, context);
        this.users     = readTLVector(stream, context);
        this.chats     = readTLVector(stream, context);
        this.date      = readInt(stream);
        this.seq_start = readInt(stream);
        this.seq       = readInt(stream);
    }

    @Override
    public String toString() {
        return "updatesCombined#725b04c3";
    }
}