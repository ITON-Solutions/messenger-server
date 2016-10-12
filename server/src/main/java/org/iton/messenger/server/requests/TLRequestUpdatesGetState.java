package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.updates.TLState;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;

public class TLRequestUpdatesGetState extends TLMethod<TLState> {
    public static final int CLASS_ID = 0xedd4882a;

    public TLRequestUpdatesGetState() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLState deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof TLState)
            return (TLState) res;
        throw new IOException("Incorrect response type. Expected TLState, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "updates.getState#edd4882a";
    }
}