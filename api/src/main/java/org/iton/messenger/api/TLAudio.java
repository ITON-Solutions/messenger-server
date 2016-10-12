package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAudio extends Audio {
    public static final int CLASS_ID = 0xc7ac6496;


    public TLAudio() {
    }

    public TLAudio(long id, long access_hash, int user_id, int date, int duration, String mime_type, int size, int dc_id) {
        this.id          = id;
        this.access_hash = access_hash;
        this.user_id     = user_id;
        this.date        = date;
        this.duration    = duration;
        this.mime_type   = mime_type;
        this.size        = size;
        this.dc_id       = dc_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream)   throws IOException {
        writeLong(this.id, stream);
        writeLong(this.access_hash, stream);
        writeInt(this.user_id, stream);
        writeInt(this.date, stream);
        writeInt(this.duration, stream);
        writeTLString(this.mime_type, stream);
        writeInt(this.size, stream);
        writeInt(this.dc_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id          = readLong(stream);
        this.access_hash = readLong(stream);
        this.user_id     = readInt(stream);
        this.date        = readInt(stream);
        this.duration    = readInt(stream);
        this.mime_type   = readTLString(stream);
        this.size        = readInt(stream);
        this.dc_id       = readInt(stream);
    }

    @Override
    public String toString() {
        return "audio#c7ac6496";
    }
}
