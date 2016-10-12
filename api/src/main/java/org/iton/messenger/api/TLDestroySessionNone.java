package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readLong;
import static org.iton.messenger.core.utils.StreamingUtils.writeLong;

public class TLDestroySessionNone extends DestroySession {

    public static final int CLASS_ID = 0x62d350c9;

    public TLDestroySessionNone() {
    }

    public TLDestroySessionNone(long session_id) {
        this.session_id = session_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.session_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.session_id = readLong(stream);
    }

    @Override
    public String toString() {
        return "destroySessionNome#62d350c9";
    }
}