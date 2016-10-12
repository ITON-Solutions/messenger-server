package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLMessageMediaWebPage extends MessageMedia {
    public static final int CLASS_ID = 0xa32dd600;

    public TLMessageMediaWebPage() {
    }

    public TLMessageMediaWebPage(WebPage webpage) {
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
        return "message.mediaWebpage#a32dd600";
    }
}