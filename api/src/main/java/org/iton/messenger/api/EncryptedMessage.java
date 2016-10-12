package org.iton.messenger.api;

import org.iton.messenger.core.TLBytes;
import org.iton.messenger.core.TLObject;

public abstract class EncryptedMessage extends TLObject {

    protected long random_id;
    protected int chat_id;
    protected int date;
    protected TLBytes bytes;
    protected EncryptedFile file;

    public long getRandomId() {
        return this.random_id;
    }

    public void setRandomId(long random_id) {
        this.random_id = random_id;
    }

    public int getChatId() {
        return this.chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLBytes getBytes() {
        return this.bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }

    public EncryptedFile getFile() {
        return file;
    }

    public void setFile(EncryptedFile file) {
        this.file = file;
    }
}

