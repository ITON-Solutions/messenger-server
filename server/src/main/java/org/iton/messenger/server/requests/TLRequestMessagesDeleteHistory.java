package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputPeer;
import org.iton.messenger.api.messages.TLAffectedHistory;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesDeleteHistory extends TLMethod<TLAffectedHistory> {
    public static final int CLASS_ID = 0xf4f8fb61;

    protected InputPeer peer;
    protected int offset;


    public TLRequestMessagesDeleteHistory() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesDeleteHistory(InputPeer peer, int offset) {
        this.peer   = peer;
        this.offset = offset;
    }

    @Override
    public TLAffectedHistory deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAffectedHistory))
            return (TLAffectedHistory) res;
        throw new IOException("Incorrect response type. Expected TLAffectedHistory, got: " + res.getClass().getCanonicalName());
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

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.peer, stream);
        writeInt(this.offset, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.peer   = ((InputPeer) readTLObject(stream, context));
        this.offset = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.deleteHistory#f4f8fb61";
    }
}