package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

/**
 * Created by ITON on 7/26/15.
 */
public class TLRequestDestroySession extends TLObject {

    public static final int CLASS_ID = 0xe7512126;

    private long session_id;

    public TLRequestDestroySession(long session_id) {
        this.session_id = session_id;
    }

    public TLRequestDestroySession() {
    }

    public long getSessionId() {
        return session_id;
    }


    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(session_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        session_id = readLong(stream);
    }

    @Override
    public String toString() {
        return "session.destroy#e7512126";
    }
}

