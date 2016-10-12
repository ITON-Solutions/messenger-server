package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUserProfilePhoto extends UserProfilePhoto {
    public static final int CLASS_ID = 0xd559d8c8;

    protected long photo_id;
    protected FileLocation photo_small;
    protected FileLocation photo_big;

    public TLUserProfilePhoto() {
    }

    public TLUserProfilePhoto(long photo_id, FileLocation photo_small, FileLocation photo_big) {
        this.photo_id    = photo_id;
        this.photo_small = photo_small;
        this.photo_big   = photo_big;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getPhotoId() {
        return this.photo_id;
    }

    public void setPhotoId(long photo_id) {
        this.photo_id = photo_id;
    }

    public FileLocation getPhotoSmall() {
        return this.photo_small;
    }

    public void setPhotoSmall(FileLocation photo_small) {
        this.photo_small = photo_small;
    }

    public FileLocation getPhotoBig() {
        return this.photo_big;
    }

    public void setPhotoBig(FileLocation photo_big) {
        this.photo_big = photo_big;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.photo_id, stream);
        writeTLObject(this.photo_small, stream);
        writeTLObject(this.photo_big, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.photo_id    = readLong(stream);
        this.photo_small = (FileLocation) readTLObject(stream, context);
        this.photo_big   = (FileLocation) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "userProfilePhoto#d559d8c8";
    }
}