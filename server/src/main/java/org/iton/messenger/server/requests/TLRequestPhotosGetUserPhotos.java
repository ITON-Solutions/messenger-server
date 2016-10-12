package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.InputUser;
import org.iton.messenger.api.photos.Photos;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestPhotosGetUserPhotos extends TLMethod<Photos> {
    public static final int CLASS_ID = 0xb7ee553c;
    protected InputUser user_id;
    protected int offset;
    protected int max_id;
    protected int limit;

    public TLRequestPhotosGetUserPhotos(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestPhotosGetUserPhotos(InputUser user_id, int offset, int max_id, int limit) {
        this.user_id = user_id;
        this.offset  = offset;
        this.max_id  = max_id;
        this.limit   = limit;
    }

    @Override
    public Photos deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof Photos))
            return (Photos) res;
        throw new IOException("Incorrect response type. Expected Photos, got: " + res.getClass().getCanonicalName());
    }

    public InputUser getUserId() {
        return this.user_id;
    }

    public void setUserId(InputUser user_id) {
        this.user_id = user_id;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getMaxId() {
        return this.max_id;
    }

    public void setMaxId(int max_id) {
        this.max_id = max_id;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.user_id, stream);
        writeInt(this.offset, stream);
        writeInt(this.max_id, stream);
        writeInt(this.limit, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = (InputUser) readTLObject(stream, context);
        this.offset  = readInt(stream);
        this.max_id  = readInt(stream);
        this.limit   = readInt(stream);
    }

    @Override
    public String toString() {
        return "photos.getUserPhotos#b7ee553c";
    }
}