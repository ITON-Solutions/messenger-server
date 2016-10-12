package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateUserBlocked extends Update {
    public static final int CLASS_ID = 0x80ece81a;

    public TLUpdateUserBlocked() {
    }

    public TLUpdateUserBlocked(int user_id, boolean blocked) {
        this.user_id = user_id;
        this.blocked = blocked;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeTLBool(this.blocked, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = readInt(stream);
        this.blocked = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "updates.userBlocked#80ece81a";
    }
}