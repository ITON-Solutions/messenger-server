package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateContactRegistered extends Update {
    public static final int CLASS_ID = 0x2575bbb9;

    public TLUpdateContactRegistered() {
    }

    public TLUpdateContactRegistered(int user_id, int date) {
        this.user_id = user_id;
        this.date    = date;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeInt(this.date, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context)throws IOException {
        this.user_id = readInt(stream);
        this.date    = readInt(stream);
    }

    public String toString() {
        return "update.contactRegistered#2575bbb9";
    }
}
