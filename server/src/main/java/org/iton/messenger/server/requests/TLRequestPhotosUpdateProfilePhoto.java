package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputPhoto;
import org.iton.messenger.api.InputPhotoCrop;
import org.iton.messenger.api.UserProfilePhoto;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestPhotosUpdateProfilePhoto extends TLMethod<UserProfilePhoto> {
    public static final int CLASS_ID = 0xeef579a0;
    protected InputPhoto id;
    protected InputPhotoCrop crop;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestPhotosUpdateProfilePhoto(){}

    public TLRequestPhotosUpdateProfilePhoto(InputPhoto id, InputPhotoCrop crop) {
        this.id   = id;
        this.crop = crop;
    }

    @Override
    public UserProfilePhoto deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof UserProfilePhoto)
            return (UserProfilePhoto) res;
        throw new IOException("Incorrect response type. UserProfilePhoto, got: " + res.getClass().getCanonicalName());
    }

    public InputPhoto getId() {
        return this.id;
    }

    public void setId(InputPhoto id) {
        this.id = id;
    }

    public InputPhotoCrop getCrop() {
        return this.crop;
    }

    public void setCrop(InputPhotoCrop crop) {
        this.crop = crop;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.id, stream);
        writeTLObject(this.crop, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id   = (InputPhoto) readTLObject(stream, context);
        this.crop = (InputPhotoCrop) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "photos.updateProfilePhoto#eef579a0";
    }
}