package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLDocumentAttributeVideo extends DocumentAttribute {
    public static final int CLASS_ID = 0x5910cccb;

    public TLDocumentAttributeVideo() {
    }

    public TLDocumentAttributeVideo(int duration, int width, int height) {
        this.duration = duration;
        this.width    = width;
        this.height   = height;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.duration, stream);
        writeInt(this.width, stream);
        writeInt(this.height, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.duration = readInt(stream);
        this.width    = readInt(stream);
        this.height   = readInt(stream);
    }

    @Override
    public String toString() {
        return "documentAttributeVideo#5910cccb";
    }
}