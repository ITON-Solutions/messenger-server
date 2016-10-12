package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLGeoChat extends Chat {
    public static final int CLASS_ID = 0x75eaea5a;

    public TLGeoChat() {
    }

    public TLGeoChat(int id,
                     long access_hash,
                     String title,
                     String address,
                     String venue,
                     GeoPoint geo,
                     ChatPhoto photo,
                     int participants_count,
                     int date,
                     boolean checked_in,
                     int version) {

        this.id                 = id;
        this.access_hash        = access_hash;
        this.title              = title;
        this.address            = address;
        this.venue              = venue;
        this.geo                = geo;
        this.photo              = photo;
        this.participants_count = participants_count;
        this.date               = date;
        this.checked_in         = checked_in;
        this.version            = version;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeLong(this.access_hash, stream);
        writeTLString(this.title, stream);
        writeTLString(this.address, stream);
        writeTLString(this.venue, stream);
        writeTLObject(this.geo, stream);
        writeTLObject(this.photo, stream);
        writeInt(this.participants_count, stream);
        writeInt(this.date, stream);
        writeTLBool(this.checked_in, stream);
        writeInt(this.version, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id                 = readInt(stream);
        this.access_hash        = readLong(stream);
        this.title              = readTLString(stream);
        this.address            = readTLString(stream);
        this.venue              = readTLString(stream);
        this.geo                = (GeoPoint) readTLObject(stream, context);
        this.photo              = (ChatPhoto) readTLObject(stream, context);
        this.participants_count = readInt(stream);
        this.date               = readInt(stream);
        this.checked_in         = readTLBool(stream);
        this.version            = readInt(stream);
    }

    @Override
    public String toString() {
        return "geoChat#75eaea5a";
    }
}