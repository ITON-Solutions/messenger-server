package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLStickerPack extends TLObject {
    public static final int CLASS_ID = 0x12b299d4;

    private String emoticon;
    private TLLongVector documents;

    public TLStickerPack() {
    }

    public TLStickerPack(String emoticon, TLLongVector documents) {
        this.emoticon  = emoticon;
        this.documents = documents;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.emoticon, stream);
        writeTLVector(this.documents, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {

        this.emoticon  = readTLString(stream);
        this.documents = readTLLongVector(stream, context);
    }

    @Override
    public String toString() {
        return "stickerPack#12b299d4";
    }
}