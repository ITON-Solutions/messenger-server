package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

public class TLPhotoSize extends PhotoSize {
    public static final int CLASS_ID = 0x77bfb61b;

    public TLPhotoSize() {
    }

    public TLPhotoSize(String type, FileLocation location, int width, int height, int size) {
        this.type     = type;
        this.location = location;
        this.width    = width;
        this.height   = height;
        this.size     = size;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        StreamingUtils.writeTLString(this.type, stream);
        StreamingUtils.writeTLObject(this.location, stream);
        StreamingUtils.writeInt(this.width, stream);
        StreamingUtils.writeInt(this.height, stream);
        StreamingUtils.writeInt(this.size, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.type = StreamingUtils.readTLString(stream);
        this.location = ((FileLocation) StreamingUtils.readTLObject(stream, context));
        this.width = StreamingUtils.readInt(stream);
        this.height = StreamingUtils.readInt(stream);
        this.size = StreamingUtils.readInt(stream);
    }

    @Override
    public String toString() {
        return "photoSize#77bfb61b";
    }
}