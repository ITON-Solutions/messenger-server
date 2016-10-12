package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class UserStatus extends TLObject
{
    protected int expires;

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }
}
