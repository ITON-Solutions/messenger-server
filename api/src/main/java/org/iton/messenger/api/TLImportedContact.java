package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLImportedContact extends TLObject {
    public static final int CLASS_ID = 0xd0028438;
    protected int user_id;
    protected long client_id;

    public TLImportedContact() {
    }

    public TLImportedContact(int user_id, long client_id) {
        this.user_id   = user_id;
        this.client_id = client_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public long getClientId() {
        return this.client_id;
    }

    public void setClientId(long client_id) {
        this.client_id = client_id;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeLong(this.client_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id   = readInt(stream);
        this.client_id = readLong(stream);
    }

    @Override
    public String toString() {
        return "importedContact#d0028438";
    }
}