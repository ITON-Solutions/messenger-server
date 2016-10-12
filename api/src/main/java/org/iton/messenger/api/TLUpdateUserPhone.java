package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateUserPhone extends Update {
    public static final int CLASS_ID = 0x12b9417b;

    public TLUpdateUserPhone() {
    }

    public TLUpdateUserPhone(int user_id, String phone) {
        this.user_id = user_id;
        this.phone   = phone;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeTLString(this.phone, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = readInt(stream);
        this.phone   = readTLString(stream);
    }

    @Override
    public String toString() {
        return "update.userPhone#12b9417b";
    }
}