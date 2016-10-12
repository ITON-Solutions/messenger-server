package org.iton.messenger.api.photos;

import org.iton.messenger.api.Photo;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Photos extends TLObject {
    protected int count;
    protected TLVector<Photo> photos;
    protected TLVector<User> users;

    public TLVector<Photo> getPhotos() {
        return this.photos;
    }

    public void setPhotos(TLVector<Photo> photos) {
        this.photos = photos;
    }

    public TLVector<User> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}