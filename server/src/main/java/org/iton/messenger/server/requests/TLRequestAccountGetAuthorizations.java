package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLAccountAuthorizations;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;

public class TLRequestAccountGetAuthorizations extends TLMethod<TLAccountAuthorizations> {

    public static final int CLASS_ID = 0xe320c158;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLAccountAuthorizations deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAccountAuthorizations))
            return (TLAccountAuthorizations) res;
        throw new IOException("Incorrect response type. Expected TLAccountAuthorizations, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "account.getAuthorizations#e320c158";
    }
}
