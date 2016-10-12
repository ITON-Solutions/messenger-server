package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLIntVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateDeleteMessages extends Update {
    public static final int CLASS_ID = 0xa20db0e5;


    public TLUpdateDeleteMessages() {
    }

    public TLUpdateDeleteMessages(TLIntVector messages, int pts, int pts_count) {
        this.messages  = messages;
        this.pts       = pts;
        this.pts_count = pts_count;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.messages, stream);
        writeInt(this.pts, stream);
        writeInt(this.pts_count, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.messages  = readTLIntVector(stream, context);
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
    }

    public String toString() {
        return "update.deleteMessages#a20db0e5";
    }
}
