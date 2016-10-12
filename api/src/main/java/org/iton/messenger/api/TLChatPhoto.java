package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLChatPhoto extends ChatPhoto {
    public static final int CLASS_ID = 0x6153276a;

    public TLChatPhoto() {
    }

    public TLChatPhoto(FileLocation photo_small, FileLocation photo_big) {
        this.photo_small = photo_small;
        this.photo_big   = photo_big;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.photo_small, stream);
        writeTLObject(this.photo_big, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.photo_small = ((FileLocation) readTLObject(stream, context));
        this.photo_big   = ((FileLocation) readTLObject(stream, context));
    }

    @Override
    public String toString() {
        return "chatPhoto#6153276a";
    }
}