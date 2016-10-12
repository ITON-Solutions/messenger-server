package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateNewGeoChatMessage extends Update {
    public static final int CLASS_ID = 0x5a68e3f7;
    protected GeoChatMessage message;

    public TLUpdateNewGeoChatMessage() {
    }

    public TLUpdateNewGeoChatMessage(GeoChatMessage message) {
        this.message = message;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public GeoChatMessage getMessage() {
        return this.message;
    }

    public void setMessage(GeoChatMessage value) {
        this.message = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.message, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context)  throws IOException {
        this.message = (GeoChatMessage) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "update.newGeoChatMessage#5a68e3f7";
    }
}
