package org.iton.messenger.api.messages;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.MessageMedia;
import org.iton.messenger.api.contacts.TLContactsLink;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLSentMessageLink extends SentMessage {
    public static final int CLASS_ID = 0x35a1a663;

    public TLSentMessageLink() {
    }

    public TLSentMessageLink(int id, int date, MessageMedia media, int pts, int pts_count, TLVector<TLContactsLink> links, int seq) {
        this.id        = id;
        this.date      = date;
        this.media     = media;
        this.pts       = pts;
        this.pts_count = pts_count;
        this.links     = links;
        this.seq       = seq;
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
        writeTLVector(links, stream);
        writeInt(this.seq, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id        = readInt(stream);
        this.date      = readInt(stream);
        this.media     = (MessageMedia) readTLObject(stream, context);
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
        this.links     = readTLVector(stream, context);
        this.seq       = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.sentMessageLink#35a1a663";
    }
}