package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.AccountPassword;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;

public class TLRequestAccountGetPassword extends TLMethod<AccountPassword> {

    public static final int CLASS_ID = 0x548a30f5;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public AccountPassword deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof AccountPassword))
            return (AccountPassword) res;
        throw new IOException("Incorrect response type. Expected AccountPassword, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "account.getPassword#548a30f5";
    }
}
