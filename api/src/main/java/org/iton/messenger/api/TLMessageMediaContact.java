package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLMessageMediaContact extends MessageMedia {
    public static final int CLASS_ID = 0x5e7d2f39;


    public TLMessageMediaContact() {
    }

    public TLMessageMediaContact(String phone_number, String first_name, String last_name, int user_id) {
        this.phone_number = phone_number;
        this.first_name   = first_name;
        this.last_name    = last_name;
        this.user_id      = user_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.phone_number, stream);
        writeTLString(this.first_name, stream);
        writeTLString(this.last_name, stream);
        writeInt(this.user_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_number = readTLString(stream);
        this.first_name   = readTLString(stream);
        this.last_name    = readTLString(stream);
        this.user_id      = readInt(stream);
    }


    @Override
    public String toString() {
        return "message.mediaContact#5e7d2f39";
    }
}