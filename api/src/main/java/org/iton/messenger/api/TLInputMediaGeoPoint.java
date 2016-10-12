package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaGeoPoint extends InputMedia {
    public static final int CLASS_ID = 0xf9c44144;

    public TLInputMediaGeoPoint() {
    }

    public TLInputMediaGeoPoint(InputGeoPoint geo_point) {
        this.geo_point = geo_point;
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.geo_point, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.geo_point = ((InputGeoPoint) readTLObject(stream, context));
    }

    public String toString() {
        return "input.mediaGeoPoint#f9c44144";
    }
}
