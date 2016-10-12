package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDocumentAttributeFilename extends DocumentAttribute {
    public static final int CLASS_ID = 0x15590068;

    public TLDocumentAttributeFilename() {
    }

    public TLDocumentAttributeFilename(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.file_name, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file_name = readTLString(stream);
    }

    @Override
    public String toString() {
        return "documentAttributeFilename#15590068";
    }
}