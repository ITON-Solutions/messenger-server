package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaUploadedDocument extends InputMedia {
    public static final int CLASS_ID = 0xffe76b78;

    public TLInputMediaUploadedDocument() {
    }

    public TLInputMediaUploadedDocument(InputFile file, String mime_type, TLVector<DocumentAttribute> attributes) {
        this.file       = file;
        this.mime_type  = mime_type;
        this.attributes = attributes;
    }

    public int getClassId() {
        return 887592125;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.file, stream);
        writeTLString(this.mime_type, stream);
        writeTLVector(this.attributes, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file       = ((InputFile) readTLObject(stream, context));
        this.mime_type  = readTLString(stream);
        this.attributes = readTLVector(stream, context);
    }

    public String toString() {
        return "input.mediaUploadedDocument#ffe76b78";
    }
}
