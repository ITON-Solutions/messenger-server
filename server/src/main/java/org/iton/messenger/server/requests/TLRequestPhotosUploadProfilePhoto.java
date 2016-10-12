package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.InputFile;
import org.iton.messenger.api.InputGeoPoint;
import org.iton.messenger.api.InputPhotoCrop;
import org.iton.messenger.api.photos.TLPhotosPhoto;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestPhotosUploadProfilePhoto extends TLMethod<TLPhotosPhoto> {
    public static final int CLASS_ID = 0xd50f9c88;
    protected InputFile file;
    protected String caption;
    protected InputGeoPoint geo_point;
    protected InputPhotoCrop crop;

    public TLRequestPhotosUploadProfilePhoto(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestPhotosUploadProfilePhoto(InputFile file, String caption, InputGeoPoint geo_point, InputPhotoCrop crop) {
        this.file      = file;
        this.caption   = caption;
        this.geo_point = geo_point;
        this.crop      = crop;
    }

    @Override
    public TLPhotosPhoto deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLPhotosPhoto))
            return (TLPhotosPhoto) res;
        throw new IOException("Incorrect response type. Expected photos.TLPhoto, got: " + res.getClass().getCanonicalName());
    }

    public InputFile getFile() {
        return this.file;
    }

    public void setFile(InputFile value) {
        this.file = value;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }

    public InputGeoPoint getGeoPoint() {
        return this.geo_point;
    }

    public void setGeoPoint(InputGeoPoint geo_point) {
        this.geo_point = geo_point;
    }

    public InputPhotoCrop getCrop() {
        return this.crop;
    }

    public void setCrop(InputPhotoCrop value) {
        this.crop = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.file, stream);
        writeTLString(this.caption, stream);
        writeTLObject(this.geo_point, stream);
        writeTLObject(this.crop, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.file      = (InputFile) readTLObject(stream, context);
        this.caption   = readTLString(stream);
        this.geo_point = (InputGeoPoint) readTLObject(stream, context);
        this.crop      = (InputPhotoCrop) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "photos.uploadProfilePhoto#d50f9c88";
    }
}
