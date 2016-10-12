package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaUploadedAudio extends InputMedia {
    public static final int CLASS_ID = 0x4e498cab;

    public TLInputMediaUploadedAudio() {
    }

    public TLInputMediaUploadedAudio(InputFile file, int duration, String mime_type) {
        this.file      = file;
        this.duration  = duration;
        this.mime_type = mime_type;
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.file, stream);
        writeInt(this.duration, stream);
        writeTLString(this.mime_type, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file      = ((InputFile) readTLObject(stream, context));
        this.duration  = readInt(stream);
        this.mime_type = readTLString(stream);
    }

    public String toString() {
        return "input.mediaUploadedAudio#4e498cab";
    }
}
