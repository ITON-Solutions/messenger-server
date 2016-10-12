package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaPhoto extends InputMedia {
    public static final int CLASS_ID = 0x8f2ab2ec;

    public TLInputMediaPhoto() {
    }

    public TLInputMediaPhoto(InputPhoto photo) {
        this.photo = photo;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.photo, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.photo = ((InputPhoto) readTLObject(stream, context));
    }

    public String toString() {
        return "input.mediaPhoto#8f2ab2ec";
    }
}
