package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountUpdateUsername extends TLMethod<User> {
    public static final int CLASS_ID = 0x3e0bdd7c;
    protected String username;

    public TLRequestAccountUpdateUsername() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountUpdateUsername(String username) {
        this.username = username;
    }

    @Override
    public User deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof User))
            return (User) res;
        throw new IOException("Incorrect response type. Expected User, got: " + res.getClass().getCanonicalName());
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
        return "account.updateUsername#3e0bdd7c";
    }
}
