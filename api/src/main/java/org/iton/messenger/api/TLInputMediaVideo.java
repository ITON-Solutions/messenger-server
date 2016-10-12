package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputMediaVideo extends InputMedia {
    public static final int CLASS_ID = 0x7f023ae6;

    public TLInputMediaVideo() {
    }

    public TLInputMediaVideo(InputVideo video) {
        this.video = video;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.video, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.video = ((InputVideo) readTLObject(stream, context));
    }

    @Override
    public String toString() {
        return "input.mediaVideo#7f023ae6";
    }
}