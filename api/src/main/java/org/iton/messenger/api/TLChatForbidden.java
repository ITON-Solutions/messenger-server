package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLChatForbidden extends Chat {
    public static final int CLASS_ID = 0xfb0ccc41;

    public TLChatForbidden() {
    }

    public TLChatForbidden(int id, String title, int date) {
        this.id    = id;
        this.title = title;
        this.date  = date;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeInt(this.date, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id    = readInt(stream);
        this.title = readTLString(stream);
        this.date  = readInt(stream);
    }

    @Override
    public String toString() {
        return "chatForbidden#fb0ccc41";
    }
}