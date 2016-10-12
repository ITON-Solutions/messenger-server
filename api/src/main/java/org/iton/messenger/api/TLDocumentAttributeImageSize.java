package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLDocumentAttributeImageSize extends DocumentAttribute {
    public static final int CLASS_ID = 0x6c37c15c;

    public TLDocumentAttributeImageSize() {
    }

    public TLDocumentAttributeImageSize(int width, int height) {
        this.width    = width;
        this.height   = height;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.width, stream);
        writeInt(this.height, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.width    = readInt(stream);
        this.height   = readInt(stream);
    }

    @Override
    public String toString() {
        return "documentAttributeImageSize#6c37c15c";
    }
}