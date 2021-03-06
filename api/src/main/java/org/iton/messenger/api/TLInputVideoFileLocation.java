package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readLong;
import static org.iton.messenger.core.utils.StreamingUtils.writeLong;

public class TLInputVideoFileLocation extends InputFileLocation {
    public static final int CLASS_ID = 0x3d0364ec;

    public TLInputVideoFileLocation() {
    }

    public TLInputVideoFileLocation(long id, long access_hash) {
        this.id          = id;
        this.access_hash = access_hash;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

     @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
        writeLong(this.access_hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id          = readLong(stream);
        this.access_hash = readLong(stream);
    }

    @Override
    public String toString() {
        return "input.videoFileLocation#3d0364ec";
    }
}