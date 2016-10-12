package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPingDelayDisconnect extends TLObject {
    public static final int CLASS_ID = 0xf3427b8c;

    private long pingId;
    private int disconnectDelay;

    public TLPingDelayDisconnect(long pingId, int disconnectDelay) {
        this.pingId = pingId;
        this.disconnectDelay = disconnectDelay;
    }

    public TLPingDelayDisconnect() {

    }

    public long getPingId() {
        return pingId;
    }

    public int getDisconnectDelay() {
        return disconnectDelay;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(pingId, stream);
        writeInt(disconnectDelay, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        pingId = readLong(stream);
        disconnectDelay = readInt(stream);
    }

    @Override
    public String toString() {
        return "pingDelayDisconnect#f3427b8c";
    }
}
