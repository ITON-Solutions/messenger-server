package org.iton.messenger.api.messages;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.MessageMedia;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLSentMessage extends SentMessage {
    public static final int CLASS_ID = 0x4c3d47f3;

    public TLSentMessage() {
    }

    public TLSentMessage(int id, int date, MessageMedia media, int pts, int pts_count) {
        this.id        = id;
        this.date      = date;
        this.media     = media;
        this.pts       = pts;
        this.pts_count = pts_count;
     }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeInt(this.date, stream);
        writeTLObject(media, stream);
        writeInt(this.pts, stream);
        writeInt(this.pts_count, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id        = readInt(stream);
        this.date      = readInt(stream);
        this.media     = (MessageMedia) readTLObject(stream, context);
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.sentMessage#4c3d47f3";
    }
}