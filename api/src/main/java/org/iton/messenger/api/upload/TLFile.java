package org.iton.messenger.api.upload;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.storage.FileType;
import org.iton.messenger.core.TLBytes;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLFile extends TLObject {
    public static final int CLASS_ID = 0x96a18d5;
    protected FileType type;
    protected int mtime;
    protected TLBytes bytes;

    public TLFile() {
    }

    public TLFile(FileType type, int mtime, TLBytes bytes) {
        this.type  = type;
        this.mtime = mtime;
        this.bytes = bytes;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public FileType getType() {
        return this.type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public int getMtime() {
        return this.mtime;
    }

    public void setMtime(int mtime) {
        this.mtime = mtime;
    }

    public TLBytes getBytes() {
        return this.bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.type, stream);
        writeInt(this.mtime, stream);
        writeTLBytes(this.bytes, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.type  = ((FileType) readTLObject(stream, context));
        this.mtime = readInt(stream);
        this.bytes = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "upload.file#96a18d5";
    }
}
