package org.iton.messenger.api.messages;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLAffectedMessages extends TLObject {
    public static final int CLASS_ID = 0x84d19185;
    protected int pts;
    protected int pts_count;

    public TLAffectedMessages() {
    }

    public TLAffectedMessages(int pts, int pts_count) {
        this.pts       = pts;
        this.pts_count = pts_count;
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

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.pts, stream);
        writeInt(this.pts_count, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.affectedMessages#84d19185";
    }
}
