package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaUploadedPhoto extends InputMedia {
    public static final int CLASS_ID = 0x2dc53a7d;

    public TLInputMediaUploadedPhoto() {
    }

    public TLInputMediaUploadedPhoto(InputFile _file) {
        this.file = _file;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.file, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file = (InputFile) readTLObject(stream, context);
    }

    public String toString() {
        return "input.mediaUploadedPhoto#2dc53a7d";
    }
}
