package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContactFound extends TLObject {
    public static final int CLASS_ID = 0xea879f95;
    protected int user_id;

    public TLContactFound() {
    }

    public TLContactFound(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = readInt(stream);
    }

    @Override
    public String toString() {
        return "contactFound#ea879f95";
    }
}