package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLWallPaperSolid extends WallPaper {
    public static final int CLASS_ID = 0x63117f24;

    public TLWallPaperSolid() {
    }

    public TLWallPaperSolid(int id, String title, int bg_color, int color) {
        this.id       = id;
        this.title    = title;
        this.bg_color = bg_color;
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
        writeInt(this.bg_color, stream);
        writeInt(this.color, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id       = readInt(stream);
        this.title    = readTLString(stream);
        this.bg_color = readInt(stream);
        this.color    = readInt(stream);
    }

    @Override
    public String toString() {
        return "wallPaperSolid#63117f24";
    }
}