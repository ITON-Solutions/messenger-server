package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

public class TLInputUserForeign extends InputUser {
    public static final int CLASS_ID = 0x655e74ff;

    public TLInputUserForeign() {
    }

    public TLInputUserForeign(int user_id, long access_hash) {
        this.user_id = user_id;
        this.access_hash = access_hash;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        StreamingUtils.writeInt(this.user_id, stream);
        StreamingUtils.writeLong(this.access_hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = StreamingUtils.readInt(stream);
        this.access_hash = StreamingUtils.readLong(stream);
    }

    @Override
    public String toString() {
        return "input.userForeign#655e74ff";
    }
}