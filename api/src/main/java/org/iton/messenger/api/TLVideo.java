package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLVideo extends Video {
    public static final int CLASS_ID = 0x388fa391;


    public TLVideo() {
    }

    public TLVideo(long id, long access_hash, int user_id, int date, String caption, int duration, String mime_type, int size, PhotoSize thumb, int dc_id, int w, int h) {
        this.id          = id;
        this.access_hash = access_hash;
        this.user_id     = user_id;
        this.date        = date;
        this.caption     = caption;
        this.duration    = duration;
        this.mime_type   = mime_type;
        this.size        = size;
        this.thumb       = thumb;
        this.dc_id       = dc_id;
        this.w           = w;
        this.h           = h;
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
        writeInt(this.duration, stream);
        writeTLString(this.mime_type, stream);
        writeInt(this.size, stream);
        writeTLObject(this.thumb, stream);
        writeInt(this.dc_id, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id          = readLong(stream);
        this.access_hash = readLong(stream);
        this.user_id     = readInt(stream);
        this.date        = readInt(stream);
        this.caption     = readTLString(stream);
        this.duration    = readInt(stream);
        this.mime_type   = readTLString(stream);
        this.size        = readInt(stream);
        this.thumb       = (PhotoSize) readTLObject(stream, context);
        this.dc_id       = readInt(stream);
        this.w           = readInt(stream);
        this.h           = readInt(stream);
    }

    @Override
    public String toString() {
        return "video#388fa391";
    }
}

