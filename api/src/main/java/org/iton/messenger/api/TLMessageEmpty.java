package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLMessageEmpty extends Message {
    public static final int CLASS_ID = 0x83e5de54;

    public TLMessageEmpty() {
    }

    public TLMessageEmpty(int id) {
        this.id = id;
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
    }

    @Override
    public String toString() {
        return "message.Empty#83e5de54";
    }
}