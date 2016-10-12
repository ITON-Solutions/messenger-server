package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPeerChat extends Peer {
    public static final int CLASS_ID = 0xbad0e5bb;

    public TLPeerChat() {
    }

    public TLPeerChat(int chat_id) {
        this.chat_id = chat_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

      @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.chat_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.chat_id = readInt(stream);
    }

    @Override
    public String toString() {
        return "peerChat#bad0e5bb";
    }
}
