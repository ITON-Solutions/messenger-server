package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class EncryptedFile extends TLObject
{
    protected long id;
    protected long access_hash;
    protected int size;
    protected int dc_id;
    protected int key_fingerprint;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDcId() {
        return dc_id;
    }

    public void setDcId(int dc_id) {
        this.dc_id = dc_id;
    }

    public int getKeyFingerprint() {
        return key_fingerprint;
    }

    public void setKeyFingerprint(int key_fingerprint) {
        this.key_fingerprint = key_fingerprint;
    }
}
