package org.iton.messenger.api.contacts;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.TLContactBlocked;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContactsBlocked extends Blocked {
    public static final int CLASS_ID = 0x1c138d15;

    public TLContactsBlocked() {
    }

    public TLContactsBlocked(TLVector<TLContactBlocked> blocked, TLVector<User> users) {
        this.blocked = blocked;
        this.users   = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.blocked, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.blocked = readTLVector(stream, context);
        this.users   = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.blocked#1c138d15";
    }
}
