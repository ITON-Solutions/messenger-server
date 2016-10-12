package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateNewMessage extends Update {
    public static final int CLASS_ID = 0x1f2b0afd;
    private Message message;

    public TLUpdateNewMessage() {
    }

    public TLUpdateNewMessage(Message message, int pts, int pts_count) {
        this.message   = message;
        this.pts       = pts;
        this.pts_count = pts_count;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.message, stream);
        writeInt(this.pts, stream);
        writeInt(this.pts_count, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.message   = (Message) readTLObject(stream, context);
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
    }

    @Override
    public String toString() {
        return "update.newMessage#1f2b0afd";
    }
}
