package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.help.TLSupport;
import org.iton.messenger.core.TLContext;

import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestHelpGetSupport extends TLMethod<TLSupport> {
    public static final int CLASS_ID = 0x9cdf08cd;

    public TLRequestHelpGetSupport(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLSupport deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof TLSupport)
            return (TLSupport) res;
        throw new IOException("Incorrect response type. Expected TLSupport, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "help.getSupport#9cdf08cd";
    }
}