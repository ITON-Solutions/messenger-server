package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPhoto extends Photo {
    public static final int CLASS_ID = 0x22b56751;


    public TLPhoto() {
    }

    public TLPhoto(long id, long access_hash, int user_id, int date, String caption, GeoPoint geo_point, TLVector<PhotoSize> sizes) {
        this.id          = id;
        this.access_hash = access_hash;
        this.user_id     = user_id;
        this.date        = date;
        this.caption     = caption;
        this.geo_point   = geo_point;
        this.sizes       = sizes;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
        writeLong(this.access_hash, stream);
        writeInt(this.user_id, stream);
        writeInt(this.date, stream);
        writeTLString(this.caption, stream);
        writeTLObject(this.geo_point, stream);
        writeTLVector(this.sizes, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id          = readLong(stream);
        this.access_hash = readLong(stream);
        this.user_id     = readInt(stream);
        this.date        = readInt(stream);
        this.caption     = readTLString(stream);
        this.geo_point   = (GeoPoint) readTLObject(stream, context);
        this.sizes       = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "photo#22b56751";
    }
}