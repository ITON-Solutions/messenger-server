package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class FileLocation extends TLObject {
    protected int dc_id;
    protected long volume_id;
    protected int local_id;
    protected long secret;
    protected String ext;
    protected byte[] key;
    protected byte[] iv;

    public int getDcId() {
        return dc_id;
    }

    public void setDcId(int dc_id) {
        this.dc_id = dc_id;
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

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public byte[] getKey() {
        return key;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }
}
