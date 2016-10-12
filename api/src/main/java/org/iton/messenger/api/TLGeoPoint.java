package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLGeoPoint extends GeoPoint {
    public static final int CLASS_ID = 0x2049d70c;
    protected double lon;
    protected double lat;

    public TLGeoPoint() {
    }

    public TLGeoPoint(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public double getLongitude() {
        return this.lon;
    }

    public void setLongitude(double lon) {
        this.lon = lon;
    }

    public double getLatitude() {
        return this.lat;
    }

    public void setLatitude(double lat) {
        this.lat = lat;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeDouble(this.lon, stream);
        writeDouble(this.lat, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.lon = readDouble(stream);
        this.lat = readDouble(stream);
    }

    @Override
    public String toString() {
        return "geoPoint#2049d70c";
    }
}