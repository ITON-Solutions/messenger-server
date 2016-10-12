package org.iton.messenger.api.updates;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLState extends TLObject {
    public static final int CLASS_ID = 0xa56c2a3e;
    protected int pts;
    protected int qts;
    protected int date;
    protected int seq;
    protected int unread_count;

    public TLState() {
    }

    public TLState(int pts, int qts, int date, int seq, int unread_count) {
        this.pts          = pts;
        this.qts          = qts;
        this.date         = date;
        this.seq          = seq;
        this.unread_count = unread_count;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getPts() {
        return this.pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getQts() {
        return this.qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSeq() {
        return this.seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getUnreadCount() {
        return this.unread_count;
    }

    public void setUnreadCount(int unread_count) {
        this.unread_count = unread_count;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.pts, stream);
        writeInt(this.qts, stream);
        writeInt(this.date, stream);
        writeInt(this.seq, stream);
        writeInt(this.unread_count, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.pts          = readInt(stream);
        this.qts          = readInt(stream);
        this.date         = readInt(stream);
        this.seq          = readInt(stream);
        this.unread_count = readInt(stream);
    }

    @Override
    public String toString() {
        return "updates.state#a56c2a3e";
    }
}