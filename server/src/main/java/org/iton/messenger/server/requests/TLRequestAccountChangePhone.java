package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountChangePhone extends TLMethod<User> {
    public static final int CLASS_ID = 0x70c32edb;
    protected String phone_number;
    protected String phone_code_hash;
    protected String phone_code;

    public TLRequestAccountChangePhone() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountChangePhone(String phone_number, String phone_code_hash, String phone_code) {
        this.phone_number    = phone_number;
        this.phone_code_hash = phone_code_hash;
        this.phone_code      = phone_code;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhoneCodeHash() {
        return phone_code_hash;
    }

    public void setPhoneCodeHash(String phone_code_hash) {
        this.phone_code_hash = phone_code_hash;
    }

    public String getPhoneCode() {
        return phone_code;
    }

    public void setPhoneCode(String phone_code) {
        this.phone_code = phone_code;
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


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.phone_number, stream);
        writeTLString(this.phone_code_hash, stream);
        writeTLString(this.phone_code, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_number    = readTLString(stream);
        this.phone_code_hash = readTLString(stream);
        this.phone_code      = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.changePhone#70c32edb";
    }

}
