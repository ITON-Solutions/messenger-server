package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.auth.TLAuthAuthorization;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAuthSignUp extends TLMethod<TLAuthAuthorization> {
    public static final int CLASS_ID = 0x1b067634;
    protected String phone_number;
    protected String phone_code_hash;
    protected String phone_code;
    protected String first_name;
    protected String last_name;

    public TLRequestAuthSignUp(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAuthSignUp(String phone_number, String phone_code_hash, String phone_code, String first_name, String last_name) {
        this.phone_number    = phone_number;
        this.phone_code_hash = phone_code_hash;
        this.phone_code      = phone_code;
        this.first_name      = first_name;
        this.last_name       = last_name;
    }

    @Override
    public TLAuthAuthorization deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof TLAuthAuthorization)
            return (TLAuthAuthorization) res;
        throw new IOException("Incorrect response type. Expected TLAuthorization, got: " + res.getClass().getCanonicalName());
    }

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhoneCodeHash() {
        return this.phone_code_hash;
    }

    public void setPhoneCodeHash(String phone_code_hash) {
        this.phone_code_hash = phone_code_hash;
    }

    public String getPhoneCode() {
        return this.phone_code;
    }

    public void setPhoneCode(String phone_code) {
        this.phone_code = phone_code;
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
        writeTLString(this.phone_number, stream);
        writeTLString(this.phone_code_hash, stream);
        writeTLString(this.phone_code, stream);
        writeTLString(this.first_name, stream);
        writeTLString(this.last_name, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_number    = readTLString(stream);
        this.phone_code_hash = readTLString(stream);
        this.phone_code      = readTLString(stream);
        this.first_name      = readTLString(stream);
        this.last_name       = readTLString(stream);
    }

    @Override
    public String toString() {
        return "auth.signUp#1b067634";
    }
}