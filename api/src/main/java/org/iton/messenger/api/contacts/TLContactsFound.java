package org.iton.messenger.api.contacts;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.TLContactFound;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContactsFound extends TLObject {

    public static final int CLASS_ID = 0x566000e;
    protected TLVector<TLContactFound> results;
    protected TLVector<User> users;

    public TLContactsFound() {
    }

    public TLContactsFound(TLVector<TLContactFound> results, TLVector<User> users) {
        this.results = results;
        this.users   = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLContactFound> getResults() {
        return this.results;
    }

    public void setResults(TLVector<TLContactFound> results) {
        this.results = results;
    }

    public TLVector<User> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.results, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.results = readTLVector(stream, context);
        this.users   = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.found#566000e";
    }
}