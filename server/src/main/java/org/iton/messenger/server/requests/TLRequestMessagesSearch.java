package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputPeer;
import org.iton.messenger.api.MessagesFilter;
import org.iton.messenger.api.messages.Messages;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesSearch extends TLMethod<Messages> {
    public static final int CLASS_ID = 0x7e9f2ab;
    protected InputPeer peer;
    protected String q;
    protected MessagesFilter filter;
    protected int min_date;
    protected int max_date;
    protected int offset;
    protected int max_id;
    protected int limit;


    public TLRequestMessagesSearch() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesSearch(InputPeer peer, String q, MessagesFilter filter, int min_date, int max_date, int offset, int max_id, int limit) {
        this.peer     = peer;
        this.q        = q;
        this.filter   = filter;
        this.min_date = min_date;
        this.max_date = max_date;
        this.offset   = offset;
        this.max_id   = max_id;
        this.limit    = limit;
    }

    @Override
    public Messages deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof Messages)
            return (Messages) res;
        throw new IOException("Incorrect response type. Expected Messages, got: " + res.getClass().getCanonicalName());
    }

    public InputPeer getPeer() {
        return this.peer;
    }

    public void setPeer(InputPeer peer) {
        this.peer = peer;
    }

    public String getQuery() {
        return this.q;
    }

    public void setQuery(String q) {
        this.q = q;
    }

    public MessagesFilter getFilter() {
        return this.filter;
    }

    public void setFilter(MessagesFilter filter) {
        this.filter = filter;
    }

    public int getMinDate() {
        return this.min_date;
    }

    public void setMinDate(int min_date) {
        this.min_date = min_date;
    }

    public int getMaxDate() {
        return this.max_date;
    }

    public void setMaxDate(int max_date) {
        this.max_date = max_date;
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
        writeTLObject(this.peer, stream);
        writeTLString(this.q, stream);
        writeTLObject(this.filter, stream);
        writeInt(this.min_date, stream);
        writeInt(this.max_date, stream);
        writeInt(this.offset, stream);
        writeInt(this.max_id, stream);
        writeInt(this.limit, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.peer     = (InputPeer) readTLObject(stream, context);
        this.q        = readTLString(stream);
        this.filter   = (MessagesFilter) readTLObject(stream, context);
        this.min_date = readInt(stream);
        this.max_date = readInt(stream);
        this.offset   = readInt(stream);
        this.max_id   = readInt(stream);
        this.limit    = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.search#7e9f2ab";
    }
}