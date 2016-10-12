package org.iton.messenger.api.contacts;

import org.iton.messenger.api.TLContact;
import org.iton.messenger.api.User;


import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

/**
 * Created by ITON Solutions on 8/11/16.
 */
public abstract class Contacts extends TLObject {

    protected TLVector<TLContact> contacts;
    protected TLVector<User> users;

    public TLVector<TLContact> getContacts() {
        return contacts;
    }

    public void setContacts(TLVector<TLContact> contacts) {
        this.contacts = contacts;
    }

    public TLVector<User> getUsers() {
        return users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }
}
