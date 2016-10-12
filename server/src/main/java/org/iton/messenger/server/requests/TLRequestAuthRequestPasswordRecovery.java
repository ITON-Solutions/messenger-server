package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.auth.TLAuthPasswordRecovery;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;

public class TLRequestAuthRequestPasswordRecovery extends TLMethod<TLAuthPasswordRecovery> {

    public static final int CLASS_ID = 0xd897bc66;

    public TLRequestAuthRequestPasswordRecovery(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLAuthPasswordRecovery deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAuthPasswordRecovery))
            return (TLAuthPasswordRecovery) res;
        throw new IOException("Incorrect response type. Expected TLAuthPasswordRecovery, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "auth.requestPasswordRecovery#d897bc66";
    }
}
