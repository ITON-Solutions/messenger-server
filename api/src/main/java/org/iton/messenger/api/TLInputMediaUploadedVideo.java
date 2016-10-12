package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaUploadedVideo extends InputMedia {
    public static final int CLASS_ID = 0x133ad6f6;

    public TLInputMediaUploadedVideo() {
    }

    public TLInputMediaUploadedVideo(InputFile file, int duration, int width, int height, String mime_type) {
        this.file      = file;
        this.duration  = duration;
        this.width     = width;
        this.height    = height;
        this.mime_type = mime_type;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.file, stream);
        writeInt(this.duration, stream);
        writeInt(this.width, stream);
        writeInt(this.height, stream);
        writeTLString(this.mime_type, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file      = ((InputFile) readTLObject(stream, context));
        this.duration  = readInt(stream);
        this.width     = readInt(stream);
        this.height    = readInt(stream);
        this.mime_type = readTLString(stream);
    }

    public String toString() {
        return "input.mediaUploadedVideo#133ad6f6";
    }
}
