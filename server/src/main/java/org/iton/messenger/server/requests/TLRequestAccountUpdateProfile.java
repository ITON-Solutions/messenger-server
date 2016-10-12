package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountUpdateProfile extends TLMethod<User> {
    public static final int CLASS_ID = 0xf0888d68;
    protected String first_name;
    protected String last_name;

    public TLRequestAccountUpdateProfile() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountUpdateProfile(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name  = last_name;
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

    public String getFirstName() {
        return this.first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.first_name, stream);
        writeTLString(this.last_name, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.first_name = readTLString(stream);
        this.last_name  = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.updateProfile#f0888d68";
    }
}
