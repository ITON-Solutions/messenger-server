package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class UserProfilePhoto extends TLObject {
    protected long photo_id;
    protected FileLocation photo_small;
    protected FileLocation photo_big;


    public long getPhotoId() {
        return photo_id;
    }

    public void setPhotoId(long photo_id) {
        this.photo_id = photo_id;
    }

    public FileLocation getPhotoSmall() {
        return photo_small;
    }

    public void setPhotoSmall(FileLocation photo_small) {
        this.photo_small = photo_small;
    }

    public FileLocation getPhotoBig() {
        return photo_big;
    }

    public void setPhotoBig(FileLocation photo_big) {
        this.photo_big = photo_big;
    }
}