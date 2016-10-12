package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputDocument extends InputDocument {
    public static final int CLASS_ID = 0x18798952;

    public TLInputDocument() {
    }

    public TLInputDocument(long id, long access_hash) {
        this.id = id;
        this.access_hash = access_hash;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
        writeLong(this.access_hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id          = readLong(stream);
        this.access_hash = readLong(stream);
    }

    @Override
    public String toString() {
        return "input.Document#18798952";
    }
}