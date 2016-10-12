package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.contacts.TLContactsFound;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestContactsSearch extends TLMethod<TLContactsFound> {
    public static final int CLASS_ID = 0x11f812d8;
    protected String query;
    protected int limit;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestContactsSearch(){}

    public TLRequestContactsSearch(String query, int limit) {
        this.query = query;
        this.limit = limit;
    }

    @Override
    public TLContactsFound deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLContactsFound))
            return (TLContactsFound) res;
        throw new IOException("Incorrect response type. Expected TLContactsFound, got: " + res.getClass().getCanonicalName());
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void serializeBody(ByteBuf stream)   throws IOException {
        writeTLString(this.query, stream);
        writeInt(this.limit, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.query = readTLString(stream);
        this.limit = readInt(stream);
    }

    @Override
    public String toString() {
        return "contacts.Search#11f812d8";
    }
}