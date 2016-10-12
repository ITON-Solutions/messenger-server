package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputPhoneContact extends TLObject {
    public static final int CLASS_ID = 0xf392b7f4;

    protected long client_id;
    protected String phone;
    protected String first_name;
    protected String last_name;

    public TLInputPhoneContact() {
    }

    public TLInputPhoneContact(long client_id, String phone, String first_name, String last_name) {
        this.client_id  = client_id;
        this.phone      = phone;
        this.first_name = first_name;
        this.last_name  = last_name;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getClientId() {
        return this.client_id;
    }

    public void setClientId(long client_id) {
        this.client_id = client_id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        writeLong(this.client_id, stream);
        writeTLString(this.phone, stream);
        writeTLString(this.first_name, stream);
        writeTLString(this.last_name, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.client_id  = readLong(stream);
        this.phone      = readTLString(stream);
        this.first_name = readTLString(stream);
        this.last_name  = readTLString(stream);
    }

    @Override
    public String toString() {
        return "input.phoneContact#f392b7f4";
    }
}