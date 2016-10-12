package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputPeerForeign extends InputPeer {
    public static final int CLASS_ID = 0x9b447325;

    public TLInputPeerForeign() {
    }

    public TLInputPeerForeign(int user_id, long access_hash) {
        this.user_id     = user_id;
        this.access_hash = access_hash;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeLong(this.access_hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id     = readInt(stream);
        this.access_hash = readLong(stream);
    }

    @Override
    public String toString() {
        return "input.peerForeign#9b447325";
    }
}
