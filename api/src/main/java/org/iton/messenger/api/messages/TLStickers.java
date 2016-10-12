package org.iton.messenger.api.messages;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.*;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLStickers extends Stickers {
    public static final int CLASS_ID = 0xdcef3102;

    public TLStickers() {
    }

    public TLStickers(String hash, TLVector<TLStickerPack> packs, TLVector<Document> documents) {
        this.hash      = hash;
        this.packs     = packs;
        this.documents = documents;
    }


    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.hash, stream);
        writeTLVector(this.packs, stream);
        writeTLVector(this.documents, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.hash      = readTLString(stream);
        this.packs     = readTLVector(stream, context);
        this.documents = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.stickers#dcef3102";
    }
}