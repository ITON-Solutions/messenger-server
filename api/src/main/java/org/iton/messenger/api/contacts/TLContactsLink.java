package org.iton.messenger.api.contacts;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContactsLink extends TLObject {
    public static final int CLASS_ID = 0x3ace484c;
    protected ContactLink myLink;
    protected ContactLink foreignLink;
    protected User user;

    public TLContactsLink() {
    }

    public TLContactsLink(ContactLink myLink, ContactLink foreignLink, User user) {
        this.myLink      = myLink;
        this.foreignLink = foreignLink;
        this.user        = user;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public ContactLink getMyLink() {
        return this.myLink;
    }

    public void setMyLink(ContactLink value) {
        this.myLink = value;
    }

    public ContactLink getForeignLink() {
        return this.foreignLink;
    }

    public void setForeignLink(ContactLink value) {
        this.foreignLink = value;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User value) {
        this.user = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.myLink, stream);
        writeTLObject(this.foreignLink, stream);
        writeTLObject(this.user, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.myLink      = (ContactLink) readTLObject(stream, context);
        this.foreignLink = (ContactLink) readTLObject(stream, context);
        this.user        = (User) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.link#3ace484c";
    }
}