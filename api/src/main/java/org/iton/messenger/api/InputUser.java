package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class InputUser extends TLObject
{

    protected int user_id;
    protected long access_hash;

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public long getAccessHash() {
        return access_hash;
    }

    public void setAccessHash(long access_hash) {
        this.access_hash = access_hash;
    }
}
