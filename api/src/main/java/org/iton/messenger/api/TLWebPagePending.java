package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLWebPagePending extends WebPage {
    public static final int CLASS_ID = 0xc586da1c;


    public TLWebPagePending() {
    }

    public TLWebPagePending(long id, int date ) {

        this.id   = id;
        this.date = date;
     }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {

        writeLong(this.id, stream);
        writeInt(this.date, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {

        id   = readLong(stream);
        date = readInt(stream);
    }

    @Override
    public String toString() {
        return "webpagePending#c586da1c";
    }
}

