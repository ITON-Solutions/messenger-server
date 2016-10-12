package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.*;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestUploadSaveFilePart extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0xb304a621;
    protected long file_id;
    protected int file_part;
    protected TLBytes bytes;

    public TLRequestUploadSaveFilePart(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestUploadSaveFilePart(long file_id, int file_part, TLBytes bytes) {
        this.file_id   = file_id;
        this.file_part = file_part;
        this.bytes     = bytes;
    }

    @Override
    public TLBool deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof TLBool)
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
    }

    public long getFileId() {
        return this.file_id;
    }

    public void setFileId(long file_id) {
        this.file_id = file_id;
    }

    public int getFilePart() {
        return this.file_part;
    }

    public void setFilePart(int file_part) {
        this.file_part = file_part;
    }

    public TLBytes getBytes() {
        return this.bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.file_id, stream);
        writeInt(this.file_part, stream);
        writeTLBytes(this.bytes, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file_id   = readLong(stream);
        this.file_part = readInt(stream);
        this.bytes     = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "upload.saveFilePart#b304a621";
    }
}