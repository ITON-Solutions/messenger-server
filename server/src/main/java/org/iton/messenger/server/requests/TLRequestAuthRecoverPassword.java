package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.auth.TLAuthAuthorization;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAuthRecoverPassword extends TLMethod<TLAuthAuthorization> {

    public static final int CLASS_ID = 0x4ea56e92;

    protected String code;

    public TLRequestAuthRecoverPassword(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLAuthAuthorization deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAuthAuthorization))
            return (TLAuthAuthorization) res;
        throw new IOException("Incorrect response type. Expected TLAuthorization, got: " + res.getClass().getCanonicalName());
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.code, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.code = readTLString(stream);
    }

    @Override
    public String toString() {
        return "auth.recoverPassword#4ea56e92";
    }
}
