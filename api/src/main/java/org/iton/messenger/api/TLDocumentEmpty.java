package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLDocumentEmpty extends Document {
    public static final int CLASS_ID = 0x36f8c871;

    public TLDocumentEmpty() {
    }

    public TLDocumentEmpty(long id) {
        this.setId(id);
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.getId(), stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.setId(readLong(stream));
    }

    @Override
    public String toString() {
        return "documentEmpty#36f8c871";
    }
}