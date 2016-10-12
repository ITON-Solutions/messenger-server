package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateMessageID extends Update {
    public static final int CLASS_ID = 0x4e90bfd6;

    public TLUpdateMessageID() {
    }

    public TLUpdateMessageID(int id, long random_id) {
        this.id        = id;
        this.random_id = random_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

     public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeLong(this.random_id, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id        = readInt(stream);
        this.random_id = readLong(stream);
    }

    public String toString() {
        return "update.MessageID#4e90bfd6";
    }
}
