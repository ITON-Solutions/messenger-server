package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputAudio extends InputAudio {
    public static final int CLASS_ID = 0x77d440ff;

    public TLInputAudio() {
    }

    public TLInputAudio(long id, long access_hash) {
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
        return "input.Audio#77d440ff";
    }
}