package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.updates.Updates;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateShort extends Updates {
    public static final int CLASS_ID = 0x78d4dec1;

    public TLUpdateShort() {
    }

    public TLUpdateShort(Update update, int date) {
        this.update = update;
        this.date   = date;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.update, stream);
        writeInt(this.date, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.update = (Update) readTLObject(stream, context);
        this.date   = readInt(stream);
    }

    @Override
    public String toString() {
        return "updates.Short#78d4dec1";
    }
}