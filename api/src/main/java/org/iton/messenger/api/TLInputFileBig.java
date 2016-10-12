package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputFileBig extends InputFile {
    public static final int CLASS_ID = 0xfa4f0bb5;

    public TLInputFileBig() {
    }

    public TLInputFileBig(long id, int parts, String _name) {
        this.id    = id;
        this.parts = parts;
        this.name  = name;
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
        writeInt(this.parts, stream);
        writeTLString(this.name, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id    = readLong(stream);
        this.parts = readInt(stream);
        this.name  = readTLString(stream);
    }

    public String toString() {
        return "input.fileBig#fa4f0bb5";
    }
}
