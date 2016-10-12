package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateNewAuthorization extends Update {
    public static final int CLASS_ID = 0x8f06529a;

    public TLUpdateNewAuthorization() {
    }

    public TLUpdateNewAuthorization(long auth_key_id, int date, String device, String location) {
        this.auth_key_id = auth_key_id;
        this.date        = date;
        this.device      = device;
        this.location    = location;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream)  throws IOException {
        writeLong(this.auth_key_id, stream);
        writeInt(this.date, stream);
        writeTLString(this.device, stream);
        writeTLString(this.location, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context)  throws IOException {
        this.auth_key_id = readLong(stream);
        this.date        = readInt(stream);
        this.device      = readTLString(stream);
        this.location    = readTLString(stream);
    }

    public String toString() {
        return "update.newAuthorization#8f06529a";
    }
}
