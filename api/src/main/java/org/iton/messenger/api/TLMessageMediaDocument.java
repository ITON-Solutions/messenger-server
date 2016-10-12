package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLMessageMediaDocument extends MessageMedia {
    public static final int CLASS_ID = 0x2fda2204;

    public TLMessageMediaDocument() {
    }

    public TLMessageMediaDocument(Document document) {
        this.document = document;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.document, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.document = ((Document) readTLObject(stream, context));
    }

    @Override
    public String toString() {
        return "message.mediaDocument#2fda2204";
    }
}