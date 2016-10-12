package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDestroySessionOK extends DestroySession {

    public static final int CLASS_ID = 0xe22045fc;

    public TLDestroySessionOK() {
    }

    public TLDestroySessionOK(long session_id) {
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
        return "destroySessionOk#e22045fc";
    }
}