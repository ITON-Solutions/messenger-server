package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLMessageMediaPhoto extends MessageMedia {
    public static final int CLASS_ID = 0xc8c45a2a;

    public TLMessageMediaPhoto() {
    }

    public TLMessageMediaPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.photo, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.photo = (Photo) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "message.mediaPhoto#c8c45a2a";
    }
}