package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.TLConfig;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;

public class TLRequestHelpGetConfig extends TLMethod<TLConfig> {
    public static final int CLASS_ID = 0xc4f9186b;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLConfig deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLConfig))
            return (TLConfig) res;
        throw new IOException("Incorrect response type. Expected TLConfig, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "help.getConfig#c4f9186b";
    }
}