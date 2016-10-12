package org.iton.messenger.api.messages;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAffectedHistory extends TLObject {
    public static final int CLASS_ID = 0xb45c69d1;
    protected int pts;
    protected int pts_count;
    protected int offset;

    public TLAffectedHistory() {
    }

    public TLAffectedHistory(int pts, int pts_count, int offset) {
        this.pts       = pts;
        this.pts_count = pts_count;
        this.offset    = offset;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getPts() {
        return this.pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getPtsCount() {
        return this.pts_count;
    }

    public void setPtsCount(int pts_count) {
        this.pts_count = pts_count;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.pts, stream);
        writeInt(this.pts_count, stream);
        writeInt(this.offset, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
        this.offset    = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.affectedHistory#b45c69d1";
    }
}
