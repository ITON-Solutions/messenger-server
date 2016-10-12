package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.contacts.Blocked;

import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLRequestContactsGetBlocked extends TLMethod<Blocked> {
    public static final int CLASS_ID = 0xf57c350f;
    protected int offset;
    protected int limit;

    public TLRequestContactsGetBlocked() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestContactsGetBlocked(int _offset, int _limit) {
        this.offset = _offset;
        this.limit = _limit;
    }

    @Override
    public Blocked deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof Blocked))
            return (Blocked) res;
        throw new IOException("Incorrect response type. Expected Blocked, got: " + res.getClass().getCanonicalName());
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.offset, stream);
        writeInt(this.limit, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.offset = readInt(stream);
        this.limit = readInt(stream);
    }

    @Override
    public String toString() {
        return "contacts.getBlocked#f57c350f";
    }
}