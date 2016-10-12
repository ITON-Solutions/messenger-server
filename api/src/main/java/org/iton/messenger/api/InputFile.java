package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class InputFile extends TLObject {
    protected long id;
    protected int parts;
    protected String name;
    protected String md5_checksum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5Checksum() {
        return md5_checksum;
    }

    public void setMd5Checksum(String md5_checksum) {
        this.md5_checksum = md5_checksum;
    }
}
