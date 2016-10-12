package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateReadHistoryOutbox extends Update {
    public static final int CLASS_ID = 0x2f2f21bf;

    private Peer peer;

    public TLUpdateReadHistoryOutbox() {
    }

    public TLUpdateReadHistoryOutbox(Peer peer, int max_id, int pts, int pts_count) {
        this.peer      = peer;
        this.max_id    = max_id;
        this.pts       = pts;
        this.pts_count = pts_count;
    }

    public Peer getPeer() {
        return this.peer;
    }

    public void setPeer(Peer peer) {
        this.peer = peer;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.peer, stream);
        writeInt(this.max_id, stream);
        writeInt(this.pts, stream);
        writeInt(this.pts_count, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.peer      = (Peer) readTLObject(stream, context);
        this.max_id    = readInt(stream);
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
    }

    @Override
    public String toString() {
        return "update.readHistoryOutbox#2f2f21bf";
    }
}