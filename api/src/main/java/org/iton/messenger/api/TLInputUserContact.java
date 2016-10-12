package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

public class TLInputUserContact extends InputUser {
    public static final int CLASS_ID = 0x86e94f65;

    public TLInputUserContact() {
    }

    public TLInputUserContact(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        StreamingUtils.writeInt(this.user_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = StreamingUtils.readInt(stream);
    }

    @Override
    public String toString() {
        return "input.userContact#86e94f65";
    }
}
