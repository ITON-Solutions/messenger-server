package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLString;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLString;

public class TLDocumentAttributeSticker extends DocumentAttribute {
    public static final int CLASS_ID = 0x994c9882;

    public TLDocumentAttributeSticker() {
    }

    public TLDocumentAttributeSticker(String alt) {
        this.alt = alt;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.alt, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.alt = readTLString(stream);
    }

    @Override
    public String toString() {
        return "documentAttributeSticker#994c9882";
    }
}