package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAuthLogOut extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x5717da40;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLBool deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLBool))
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected org.telegram.server.tl.TLBool, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "auth.logOut#5717da40";
    }
}
