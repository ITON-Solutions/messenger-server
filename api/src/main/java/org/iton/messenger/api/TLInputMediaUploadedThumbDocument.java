package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaUploadedThumbDocument extends InputMedia {
    public static final int CLASS_ID = 0x41481486;


    public TLInputMediaUploadedThumbDocument() {
    }

    public TLInputMediaUploadedThumbDocument(InputFile file, InputFile thumb, String mime_type, TLVector<DocumentAttribute> attributes) {
        this.file       = file;
        this.thumb      = thumb;
        this.mime_type  = mime_type;
        this.attributes = attributes;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.file, stream);
        writeTLObject(this.thumb, stream);
        writeTLString(this.mime_type, stream);
        writeTLVector(this.attributes, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file       = ((InputFile) readTLObject(stream, context));
        this.thumb      = ((InputFile) readTLObject(stream, context));
        this.mime_type  = readTLString(stream);
        this.attributes = readTLVector(stream, context);
    }

    public String toString() {
        return "input.mediaUploadedThumbDocument#41481486";
    }
}
