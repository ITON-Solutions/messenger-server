package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateActivation extends Update {
    public static final int CLASS_ID = 0x6f690963;

    public TLUpdateActivation() {
    }

    public TLUpdateActivation(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
        return "update.Activation#6f690963";
    }
}