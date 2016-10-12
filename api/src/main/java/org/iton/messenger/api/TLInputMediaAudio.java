package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaAudio extends InputMedia {
    public static final int CLASS_ID = 0x89938781;

    public TLInputMediaAudio() {
    }

    public TLInputMediaAudio(InputAudio audio) {
        this.audio = audio;
    }

    public int getClassId() {
        return CLASS_ID;
    }


    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.audio, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.audio = ((InputAudio) readTLObject(stream, context));
    }

    public String toString() {
        return "input.mediaAudio#89938781";
    }
}
