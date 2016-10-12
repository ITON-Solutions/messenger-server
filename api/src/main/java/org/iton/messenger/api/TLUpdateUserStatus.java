package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateUserStatus extends Update {
    public static final int CLASS_ID = 0x1bfbd823;


    public TLUpdateUserStatus() {
    }

    public TLUpdateUserStatus(int user_id, UserStatus status) {
        this.user_id = user_id;
        this.status  = status;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.user_id, stream);
        writeTLObject(this.status, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = readInt(stream);
        this.status  = (UserStatus) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "update.userStatus#1bfbd823";
    }
}