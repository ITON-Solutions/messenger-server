package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;


public abstract class Document extends TLObject {
    protected long id;
    protected long access_hash;
    protected int date;
    protected String mime_type;
    protected int size;
    protected PhotoSize thumb;
    protected int dc_id;
    protected TLVector<DocumentAttribute> attributes = new TLVector<>();
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
    }

    public int getDcId() {
        return dc_id;
    }

    public void setDcId(int dc_id) {
        this.dc_id = dc_id;
    }

    public TLVector<DocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<DocumentAttribute> attributes) {
        this.attributes = attributes;
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
