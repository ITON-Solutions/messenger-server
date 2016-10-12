package org.iton.messenger.api.photos;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.Photo;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPhotosSlice extends Photos {
    public static final int CLASS_ID = 0x15051f54;


    public TLPhotosSlice() {
    }

    public TLPhotosSlice(int count, TLVector<Photo> photos, TLVector<User> users) {
        this.count  = count;
        this.photos = photos;
        this.users  = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.count, stream);
        writeTLVector(this.photos, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.count  = readInt(stream);
        this.photos = readTLVector(stream, context);
        this.users  = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "photos.photosSlice#15051f54";
    }
}