package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLChatEmpty extends Chat {
    public static final int CLASS_ID = 0x9ba2d800;

    public TLChatEmpty() {
    }

    public TLChatEmpty(int id) {
        this.id = id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream)  throws IOException {
        writeInt(this.id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id    = readInt(stream);
        this.title = "DELETED";
    }

    @Override
    public String toString() {
        return "chatEmpty#9ba2d800";
    }
}