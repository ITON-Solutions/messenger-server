package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputPeer;
import org.iton.messenger.api.SendMessageAction;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesSetTyping extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0xa3825e50;
    protected InputPeer peer;
    protected SendMessageAction action;

    public TLRequestMessagesSetTyping(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesSetTyping(InputPeer peer, SendMessageAction action) {
        this.peer   = peer;
        this.action = action;
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

    public InputPeer getPeer() {
        return this.peer;
    }

    public void setPeer(InputPeer peer) {
        this.peer = peer;
    }

    public SendMessageAction getAction() {
        return this.action;
    }

    public void setAction(SendMessageAction action) {
        this.action = action;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.peer, stream);
        writeTLObject(this.action, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context)  throws IOException {
        this.peer   = (InputPeer) readTLObject(stream, context);
        this.action = (SendMessageAction) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messages.setTyping#a3825e50";
    }
}