package org.iton.messenger.api.updates;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDifferenceEmpty extends Difference {
    public static final int CLASS_ID = 0x5d75a138;

    public TLDifferenceEmpty() {
    }

    public TLDifferenceEmpty(int date, int seq) {
        this.date = date;
        this.seq  = seq;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.date, stream);
        writeInt(this.seq, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.date = readInt(stream);
        this.seq  = readInt(stream);
    }

    @Override
    public String toString() {
        return "updates.differenceEmpty#5d75a138";
    }
}