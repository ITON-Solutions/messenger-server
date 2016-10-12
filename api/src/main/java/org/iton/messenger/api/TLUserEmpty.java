package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLUserEmpty extends User {
    public static final int CLASS_ID = 0x200250ba;

    public TLUserEmpty() {
    }

    public TLUserEmpty(int id) {
        this.setId(id);
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id = readInt(stream);

        this.first_name = "DELETED";
        this.last_name = "";
        this.phone = "";
        this.status = new TLUserStatusEmpty();
    }

    @Override
    public String toString() {
        return "userEmpty#200250ba";
    }
}