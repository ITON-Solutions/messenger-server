package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.messages.TLMessagesChatFull;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesGetFullChat extends TLMethod<TLMessagesChatFull> {
    public static final int CLASS_ID = 0x3b831c66;
    protected int chat_id;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesGetFullChat(){}

    public TLRequestMessagesGetFullChat(int chat_id) {
        this.chat_id = chat_id;
    }

    @Override
    public TLMessagesChatFull deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLMessagesChatFull))
            return (TLMessagesChatFull) res;
        throw new IOException("Incorrect response type. Expected TLMessagesChatFull, got: " + res.getClass().getCanonicalName());
    }

    public int getChatId() {
        return this.chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }

    @Override
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeInt(this.chat_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.chat_id = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.getFullChat#3b831c66";
    }
}