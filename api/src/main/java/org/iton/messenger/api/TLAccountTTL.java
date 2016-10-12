package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountTTL extends TLObject {

    public static final int CLASS_ID = 0xb8d0afdf;
    protected int days;

    public TLAccountTTL() {
    }

    public TLAccountTTL(int days) {
        this.days = days;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }


    @Override
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeInt(this.days, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.days = readInt(stream);
    }

    @Override
    public String toString() {
        return "account.TTL#b8d0afdf";
    }
}
