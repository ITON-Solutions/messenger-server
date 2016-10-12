package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.messages.TLAffectedMessages;
import org.iton.messenger.core.*;
import org.iton.messenger.core.utils.StreamingUtils;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;

public class TLRequestMessagesDeleteMessages extends TLMethod<TLAffectedMessages> {
    public static final int CLASS_ID = 0xa5f18925;

    protected TLIntVector id;

    public TLRequestMessagesDeleteMessages(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesDeleteMessages(TLIntVector id) {
        this.id = id;
    }

    @Override
    public TLAffectedMessages deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAffectedMessages))
            return (TLAffectedMessages) res;
        throw new IOException("Incorrect response type. Expected TLAffectedMessages, got: " + res.getClass().getCanonicalName());
    }

    public TLIntVector getId() {
        return this.id;
    }

    public void setId(TLIntVector value) {
        this.id = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        StreamingUtils.writeTLVector(this.id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id = StreamingUtils.readTLIntVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.deleteMessages#a5f18925";
    }
}