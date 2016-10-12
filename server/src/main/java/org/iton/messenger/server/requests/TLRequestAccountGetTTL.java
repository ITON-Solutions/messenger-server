package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLAccountTTL;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;

public class TLRequestAccountGetTTL extends TLMethod<TLAccountTTL> {

    public static final int CLASS_ID = 0x8fc711d;

    public TLRequestAccountGetTTL(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLAccountTTL deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAccountTTL))
            return (TLAccountTTL) res;
        throw new IOException("Incorrect response type. Expected TLAccountTTL, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "account.getTTL#8fc711d";
    }
}
