package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaDocument extends InputMedia {
    public static final int CLASS_ID = 0xd184e841;

    public TLInputMediaDocument() {
    }

    public TLInputMediaDocument(InputDocument document) {
        this.document = document;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.document, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.document = ((InputDocument) readTLObject(stream, context));
    }

    public String toString() {
        return "input.mediaDocument#d184e841";
    }
}
