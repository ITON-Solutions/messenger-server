package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAudioEmpty extends Audio {
    public static final int CLASS_ID = 0x586988d8;

    public TLAudioEmpty() {
    }

    public TLAudioEmpty(long id) {
        this.id = id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id = readLong(stream);
    }

    @Override
    public String toString() {
        return "audioEmpty#586988d8";
    }
}