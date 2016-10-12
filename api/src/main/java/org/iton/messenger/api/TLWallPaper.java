package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLWallPaper extends WallPaper {
    public static final int CLASS_ID = 0xccb03657;

    public TLWallPaper() {
    }

    public TLWallPaper(int id, String title, TLVector<PhotoSize> sizes, int color) {
        this.id       = id;
        this.title    = title;
        this.sizes    = sizes;
        this.color    = color;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeTLVector(this.sizes, stream);
        writeInt(this.color, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id       = readInt(stream);
        this.title    = readTLString(stream);
        this.sizes    = readTLVector(stream, context);
        this.color    = readInt(stream);
    }

    @Override
    public String toString() {
        return "wallPaper#ccb03657";
    }
}
