package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class InputAudio extends TLObject
{
    protected long id;
    protected long access_hash;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return access_hash;
    }

    public void setAccessHash(long access_hash) {
        this.access_hash = access_hash;
    }
}
