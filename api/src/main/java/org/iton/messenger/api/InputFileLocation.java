package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class InputFileLocation extends TLObject
{
    protected long id;
    protected long access_hash;
    protected long volume_id;
    protected int local_id;
    protected long secret;

    public long getAccessHash() {
        return access_hash;
    }

    public void setAccessHash(long access_hash) {
        this.access_hash = access_hash;
    }

    public long getVolumeId() {
        return volume_id;
    }

    public void setVolumeId(long volume_id) {
        this.volume_id = volume_id;
    }

    public int getLocalId() {
        return local_id;
    }

    public void setLocalId(int local_id) {
        this.local_id = local_id;
    }

    public long getSecret() {
        return secret;
    }

    public void setSecret(long secret) {
        this.secret = secret;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
