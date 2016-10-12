package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLContactBlocked extends TLObject {
    public static final int CLASS_ID = 0x561bc879;
    protected int userId;
    protected int date;

    public TLContactBlocked() {
    }

    public TLContactBlocked(int _userId, int _date) {
        this.userId = _userId;
        this.date = _date;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.userId, stream);
        writeInt(this.date, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.userId = readInt(stream);
        this.date   = readInt(stream);
    }

    @Override
    public String toString() {
        return "contactBlocked#561bc879";
    }
}