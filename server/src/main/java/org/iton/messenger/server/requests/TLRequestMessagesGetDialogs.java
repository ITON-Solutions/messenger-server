package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.messages.Dialogs;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLRequestMessagesGetDialogs extends TLMethod<Dialogs> {
    public static final int CLASS_ID = 0xeccf1df6;
    protected int offset;
    protected int max_id;
    protected int limit;

    public TLRequestMessagesGetDialogs() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesGetDialogs(int offset, int max_id, int limit) {
        this.offset = offset;
        this.max_id = max_id;
        this.limit  = limit;
    }

    @Override
    public Dialogs deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof Dialogs))
            return (Dialogs) res;
        throw new IOException("Incorrect response type. Expected Dialogs, got: " + res.getClass().getCanonicalName());
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
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeInt(this.offset, stream);
        writeInt(this.max_id, stream);
        writeInt(this.limit, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.offset = readInt(stream);
        this.max_id = readInt(stream);
        this.limit  = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.getDialogs#eccf1df6";
    }
}