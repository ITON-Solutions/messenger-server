package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContact extends TLObject {
    public static final int CLASS_ID = 0xf911c994;
    protected int user_id;
    protected boolean mutual;

    public TLContact() {
    }

    public TLContact(int user_id, boolean mutual) {
        this.user_id = user_id;
        this.mutual  = mutual;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public boolean getMutual() {
        return this.mutual;
    }

    public void setMutual(boolean mutual) {
        this.mutual = mutual;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeTLBool(this.mutual, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = readInt(stream);
        this.mutual  = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "contact#f911c994";
    }
}