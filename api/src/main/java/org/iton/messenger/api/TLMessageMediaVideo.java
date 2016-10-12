package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLMessageMediaVideo extends MessageMedia {
    public static final int CLASS_ID = 0xa2d24290;

    public TLMessageMediaVideo() {
    }

    public TLMessageMediaVideo(Video video) {
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
        this.video = (Video) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "message.mediaVideo#a2d24290";
    }
}