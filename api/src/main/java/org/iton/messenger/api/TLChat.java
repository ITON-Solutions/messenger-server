package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLChat extends Chat {
    public static final int CLASS_ID = 0x6e9c9bc7;

    public TLChat() {
    }

    public TLChat(int id, String title, ChatPhoto photo, int participants_count, int date, boolean left, int version) {
        this.id                 = id;
        this.title              = title;
        this.photo              = photo;
        this.participants_count = participants_count;
        this.date               = date;
        this.left               = left;
        this.version            = version;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeTLObject(this.photo, stream);
        writeInt(this.participants_count, stream);
        writeInt(this.date, stream);
        writeTLBool(this.left, stream);
        writeInt(this.version, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context)  throws IOException {
        this.id                 = readInt(stream);
        this.title              = readTLString(stream);
        this.photo              = (ChatPhoto) readTLObject(stream, context);
        this.participants_count = readInt(stream);
        this.date               = readInt(stream);
        this.left               = readTLBool(stream);
        this.version            = readInt(stream);
    }

    @Override
    public String toString() {
        return "chat#6e9c9bc7";
    }
}