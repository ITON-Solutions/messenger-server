package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputPhotoCrop extends InputPhotoCrop {
    public static final int CLASS_ID = 0xd9915325;

    public TLInputPhotoCrop() {
    }

    public TLInputPhotoCrop(double crop_left, double crop_top, double crop_width) {
        this.crop_left  = crop_left;
        this.crop_top   = crop_top;
        this.crop_width = crop_width;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeDouble(this.crop_left, stream);
        writeDouble(this.crop_top, stream);
        writeDouble(this.crop_width, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.crop_left  = readDouble(stream);
        this.crop_top   = readDouble(stream);
        this.crop_width = readDouble(stream);
    }

    @Override
    public String toString() {
        return "inputPhotoCrop#d9915325";
    }
}