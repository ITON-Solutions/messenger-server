package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readLong;
import static org.iton.messenger.core.utils.StreamingUtils.writeLong;

public class TLPing extends TLObject {
    public static final int CLASS_ID = 0x7abe77ec;

    private long pingId;

    public TLPing(long pingId) {
        this.pingId = pingId;
    }

    public TLPing() {

    }

    public long getPingId(){
        return pingId;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(pingId, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        pingId = readLong(stream);
    }

    @Override
    public String toString() {
        return "ping#7abe77ec";
    }
}
