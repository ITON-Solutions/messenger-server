package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.contacts.Contacts;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestContactsGetContacts extends TLMethod<Contacts> {
    public static final int CLASS_ID = 0x22c6aa08;

    protected String hash;

    public TLRequestContactsGetContacts() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestContactsGetContacts(String hash) {
        this.hash = hash;
    }

    @Override
    public Contacts deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof Contacts))
            return (Contacts) res;
        throw new IOException("Incorrect response type. Expected Contacts, got: " + res.getClass().getCanonicalName());
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.hash = readTLString(stream);
    }

    @Override
    public String toString() {
        return "contacts.getContacts#22c6aa08";
    }
}