package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLMessageMediaAudio extends MessageMedia {
    public static final int CLASS_ID = 0xc6b68300;

    public TLMessageMediaAudio() {
    }

    public TLMessageMediaAudio(Audio audio) {
        this.audio = audio;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.audio, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.audio = (Audio) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "message.mediaAudio#c6b68300";
    }
}