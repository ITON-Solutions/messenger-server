package org.iton.messenger.api;

import org.iton.messenger.core.TLIntVector;
import org.iton.messenger.core.TLObject;

public abstract class PrivacyRule extends TLObject
{
    protected TLIntVector users;


    public TLIntVector getUsers() {
        return users;
    }

    public void setUsers(TLIntVector users) {
        this.users = users;
    }
}
