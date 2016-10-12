package org.iton.messenger.api.contacts;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.TLContact;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContacts extends Contacts {
    public static final int CLASS_ID = 0x6f8b8cb2;

    public TLContacts() {
    }

    public TLContacts(TLVector<TLContact> contacts, TLVector<User> users) {
        this.contacts = contacts;
        this.users    = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.contacts, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.contacts = readTLVector(stream, context);
        this.users    = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.contacts#6f8b8cb2";
    }
}