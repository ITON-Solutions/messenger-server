package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLWebPageEmpty extends WebPage {
    public static final int CLASS_ID = 0xeb1477e8;

    public TLWebPageEmpty() {
    }

    public TLWebPageEmpty(long id) {
        this.id = id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id = readLong(stream);
    }

    @Override
    public String toString() {
        return "webpageEmpty#eb1477e8";
    }
}