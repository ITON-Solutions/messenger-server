package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDocumentAttributeAudio extends DocumentAttribute {
    public static final int CLASS_ID = 0x51448e5;

    public TLDocumentAttributeAudio() {
    }

    public TLDocumentAttributeAudio(int duration) {
        this.duration = duration;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.duration, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.duration = readInt(stream);
    }

    @Override
    public String toString() {
        return "documentAttributeAudio#51448e5";
    }
}