package org.iton.messenger.api.help;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLSupport extends TLObject {
    public static final int CLASS_ID = 0x17c6b5f6;

    protected String phone_number;
    protected User user;

    public TLSupport() {
    }

    public TLSupport(String phone_number, User user) {
        this.phone_number = phone_number;
        this.user         = user;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeTLString(this.phone_number, stream);
        writeTLObject(this.user, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_number = readTLString(stream);
        this.user         = (User) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "help.support#17c6b5f6";
    }
}