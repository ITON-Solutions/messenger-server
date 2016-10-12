package org.iton.messenger.api.photos;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.Photo;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPhotosPhoto extends TLObject {
    public static final int CLASS_ID = 0x20212ca8;
    protected Photo photo;
    protected TLVector<User> users;

    public TLPhotosPhoto() {
    }

    public TLPhotosPhoto(Photo photo, TLVector<User> users) {
        this.photo = photo;
        this.users = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public TLVector<User> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    @Override
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeTLObject(this.photo, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.photo = (Photo) readTLObject(stream, context);
        this.users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "photos.photo#20212ca8";
    }
}