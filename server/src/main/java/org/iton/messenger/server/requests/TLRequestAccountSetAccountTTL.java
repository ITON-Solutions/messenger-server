package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLAccountTTL;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLObject;

public class TLRequestAccountSetAccountTTL extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x2442485e;

    protected TLAccountTTL ttl;

    public TLRequestAccountSetAccountTTL(){}

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
        throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
    }



    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.ttl, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.ttl = (TLAccountTTL) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "account.setAccountTTL#2442485e";
    }

    public TLAccountTTL getTTL() {
        return ttl;
    }

    public void setTTL(TLAccountTTL ttl) {
        this.ttl = ttl;
    }
}
