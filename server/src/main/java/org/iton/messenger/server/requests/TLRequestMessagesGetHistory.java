package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputPeer;
import org.iton.messenger.api.messages.Messages;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesGetHistory extends TLMethod<Messages> {
    public static final int CLASS_ID = 0x92a1df2f;
    protected InputPeer peer;
    protected int offset;
    protected int max_id;
    protected int limit;

    public TLRequestMessagesGetHistory() {}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesGetHistory(InputPeer peer, int offset, int max_id, int limit) {
        this.peer   = peer;
        this.offset = offset;
        this.max_id = max_id;
        this.limit  = limit;
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
        writeInt(this.offset, stream);
        writeInt(this.max_id, stream);
        writeInt(this.limit, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.peer   = (InputPeer) readTLObject(stream, context);
        this.offset = readInt(stream);
        this.max_id = readInt(stream);
        this.limit  = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.getHistory#92a1df2f";
    }
}