package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class Audio extends TLObject {
    protected long id;
    protected long access_hash;
    protected int user_id;
    protected int date;
    protected int duration;
    protected String mime_type;
    protected int size;
    protected int dc_id;
    protected byte[] key;
    protected byte[] iv;

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

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMimeType() {
        return mime_type;
    }

    public void setMimeType(String mime_type) {
        this.mime_type = mime_type;
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
