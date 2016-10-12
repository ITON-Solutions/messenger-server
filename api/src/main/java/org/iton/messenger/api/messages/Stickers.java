package org.iton.messenger.api.messages;

import org.iton.messenger.api.*;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Stickers extends TLObject {
    protected String hash;
    protected TLVector<TLStickerPack> packs = new TLVector<>();
    protected TLVector<Document> documents = new TLVector<>();

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public TLVector<TLStickerPack> getPacks() {
        return packs;
    }

    public void setPacks(TLVector<TLStickerPack> packs) {
        this.packs = packs;
    }

    public TLVector<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(TLVector<Document> documents) {
        this.documents = documents;
    }
}