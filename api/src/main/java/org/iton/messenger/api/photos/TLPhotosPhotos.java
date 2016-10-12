package org.iton.messenger.api.photos;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.Photo;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPhotosPhotos extends Photos {
    public static final int CLASS_ID = 0x8dca6aa5;

    public TLPhotosPhotos() {
    }

    public TLPhotosPhotos(TLVector<Photo> photos, TLVector<User> users) {
        this.photos = photos;
        this.users  = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.photos, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.photos = readTLVector(stream, context);
        this.users  = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "photos.photos#8dca6aa5";
    }
}