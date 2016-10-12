package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLContactStatus extends TLObject {
    public static final int CLASS_ID = 0xd3680c61;
    protected int user_id;
    protected UserStatus status;

    public TLContactStatus() {
    }

    public TLContactStatus(int user_id, UserStatus status) {
        this.user_id = user_id;
        this.status  = status;
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
        writeTLObject(this.status, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id = readInt(stream);
        this.status  = (UserStatus) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "contactStatus#d3680c61";
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}