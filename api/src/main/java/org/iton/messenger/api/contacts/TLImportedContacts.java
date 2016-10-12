package org.iton.messenger.api.contacts;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.TLImportedContact;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLImportedContacts extends TLObject {
    public static final int CLASS_ID = 0xad524315;

    protected TLVector<TLImportedContact> imported;
    private TLLongVector retry_contacts;
    protected TLVector<User> users;

    public TLImportedContacts() {
    }

    public TLImportedContacts(TLVector<TLImportedContact> imported, TLLongVector retry_contacts, TLVector<User> users) {
        this.imported       = imported;
        this.retry_contacts = retry_contacts;
        this.users          = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLImportedContact> getImported() {
        return this.imported;
    }

    public void setImported(TLVector<TLImportedContact> imported) {
        this.imported = imported;
    }

    public TLLongVector getRetryContacts() {
        return retry_contacts;
    }

    public void setRetryContacts(TLLongVector retry_contacts) {
        this.retry_contacts = retry_contacts;
    }

    public TLVector<User> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.imported, stream);
        writeTLVector(this.retry_contacts, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.imported       = readTLVector(stream, context);
        this.retry_contacts = readTLLongVector(stream, context);
        this.users          = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.importedContacts#ad524315";
    }
}