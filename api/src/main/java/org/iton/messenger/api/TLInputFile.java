package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputFile extends InputFile {
    public static final int CLASS_ID = 0xf52ff27f;

    public TLInputFile() {
    }

    public TLInputFile(long id, int parts, String name, String md5_checksum) {
        this.id           = id;
        this.parts        = parts;
        this.name         = name;
        this.md5_checksum = md5_checksum;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

     @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
        writeInt(this.parts, stream);
        writeTLString(this.name, stream);
        writeTLString(this.md5_checksum, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id           = readLong(stream);
        this.parts        = readInt(stream);
        this.name         = readTLString(stream);
        this.md5_checksum = readTLString(stream);
    }

    @Override
    public String toString() {
        return "input.File#f52ff27f";
    }
}