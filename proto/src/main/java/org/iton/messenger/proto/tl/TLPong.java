package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readLong;
import static org.iton.messenger.core.utils.StreamingUtils.writeLong;

public class TLPong extends TLObject {

    public static final int CLASS_ID = 0x347773c5;

    private long messageId;
    private long pingId;

    public TLPong(long messageId, long pingId) {
        this.messageId = messageId;
        this.pingId = pingId;
    }

    public TLPong() {
    }

    public long getMessageId() {
        return messageId;
    }

    public long getPingId() {
        return pingId;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(messageId, stream);
        writeLong(pingId, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        messageId = readLong(stream);
        pingId = readLong(stream);
    }

    @Override
    public String toString() {
        return "pong#347773c5";
    }
}
