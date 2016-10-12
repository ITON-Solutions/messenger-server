package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateWebPage extends Update {
    public static final int CLASS_ID = 0x2cc36971;

    public TLUpdateWebPage() {
    }

    public TLUpdateWebPage(WebPage webpage) {
        this.webpage = webpage;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.webpage, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.webpage = (WebPage) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "update.Webpage#2cc36971";
    }
}