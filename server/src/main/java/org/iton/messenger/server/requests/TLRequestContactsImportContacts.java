package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLInputPhoneContact;
import org.iton.messenger.api.contacts.TLImportedContacts;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;


import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestContactsImportContacts extends TLMethod<TLImportedContacts> {

    public static final int CLASS_ID = 0xda30b32d;

    protected TLVector<TLInputPhoneContact> contacts;
    protected boolean replace;

    public TLRequestContactsImportContacts(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestContactsImportContacts(TLVector<TLInputPhoneContact> contacts, boolean replace) {
        this.contacts = contacts;
        this.replace  = replace;
    }

    @Override
    public TLImportedContacts deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof TLImportedContacts)
            return (TLImportedContacts) res;
        throw new IOException("Incorrect response type. Expected TLImportedContacts, got: " + res.getClass().getCanonicalName());
    }

    public TLVector<TLInputPhoneContact> getContacts() {
        return this.contacts;
    }

    public void setContacts(TLVector<TLInputPhoneContact> contacts) {
        this.contacts = contacts;
    }

    public boolean getReplace() {
        return this.replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.contacts, stream);
        writeTLBool(this.replace, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.contacts = readTLVector(stream, context);
        this.replace  = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "contacts.importContacts#da30b32d";
    }
}