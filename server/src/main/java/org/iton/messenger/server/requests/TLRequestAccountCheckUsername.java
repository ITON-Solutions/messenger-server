package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountCheckUsername extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0x2714d86c;
    protected String username;

    public TLRequestAccountCheckUsername() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountCheckUsername(String username) {
        this.username = username;
    }

    @Override
    public TLBool deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLBool))
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
    }

    public String getUserName() {
        return this.username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.username, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.username = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.checkUsername#2714d86c";
    }
}
