package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaContact extends InputMedia {
    public static final int CLASS_ID = 0xa6e45987;

    public TLInputMediaContact() {
    }

    public TLInputMediaContact(String phone_number, String first_name, String last_name) {
        this.phone_number = phone_number;
        this.first_name   = first_name;
        this.last_name    = last_name;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.phone_number, stream);
        writeTLString(this.first_name, stream);
        writeTLString(this.last_name, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_number = readTLString(stream);
        this.first_name   = readTLString(stream);
        this.last_name    = readTLString(stream);
    }

    public String toString() {
        return "input.mediaContact#a6e45987";
    }
}
