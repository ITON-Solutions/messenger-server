package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputGeoPoint extends InputGeoPoint {
    public static final int CLASS_ID = 0xf3b7acc9;

    public TLInputGeoPoint() {
    }

    public TLInputGeoPoint(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream) throws IOException {
        writeDouble(this.lat, stream);
        writeDouble(this.lng, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.lat = readDouble(stream);
        this.lng = readDouble(stream);
    }

    public String toString() {
        return "input.geoPoint#f3b7acc9";
    }
}
