package org.iton.messenger.api.contacts;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.TLContactBlocked;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContactsBlockedSlice extends Blocked {
    public static final int CLASS_ID = 0x900802a1;

    public TLContactsBlockedSlice() {
    }

    public TLContactsBlockedSlice(int count, TLVector<TLContactBlocked> blocked, TLVector<User> users) {
        this.count   = count;
        this.blocked = blocked;
        this.users   = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int value) {
        this.count = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.count, stream);
        writeTLVector(this.blocked, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.count   = readInt(stream);
        this.blocked = readTLVector(stream, context);
        this.users   = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.blockedSlice#900802a1";
    }
}