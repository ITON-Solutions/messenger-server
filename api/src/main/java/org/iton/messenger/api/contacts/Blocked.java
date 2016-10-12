package org.iton.messenger.api.contacts;

import org.iton.messenger.api.TLContactBlocked;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Blocked extends TLObject {
    protected TLVector<TLContactBlocked> blocked;
    protected TLVector<User> users;
    protected int count;

    public TLVector<TLContactBlocked> getBlocked() {
        return this.blocked;
    }

    public void setBlocked(TLVector<TLContactBlocked> blocked) {
        this.blocked = blocked;
    }

    public TLVector<User> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
