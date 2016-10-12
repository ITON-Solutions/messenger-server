package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.InputFileLocation;
import org.iton.messenger.api.upload.TLFile;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestUploadGetFile extends TLMethod<TLFile> {
    public static final int CLASS_ID = 0xe3a6cfb5;
    protected InputFileLocation location;
    protected int offset;
    protected int limit;

    public TLRequestUploadGetFile(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestUploadGetFile(InputFileLocation location, int offset, int limit) {
        this.location = location;
        this.offset   = offset;
        this.limit    = limit;
    }

    @Override
    public TLFile deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLFile))
            return (TLFile) res;
        throw new IOException("Incorrect response type. TLFile, got: " + res.getClass().getCanonicalName());
    }

    public InputFileLocation getLocation() {
        return this.location;
    }

    public void setLocation(InputFileLocation location) {
        this.location = location;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.location, stream);
        writeInt(this.offset, stream);
        writeInt(this.limit, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.location = (InputFileLocation) readTLObject(stream, context);
        this.offset   = readInt(stream);
        this.limit    = readInt(stream);
    }

    @Override
    public String toString() {
        return "upload.getFile#e3a6cfb5";
    }
}