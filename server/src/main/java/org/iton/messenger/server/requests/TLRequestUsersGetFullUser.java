package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputUser;
import org.iton.messenger.api.TLUserFull;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestUsersGetFullUser extends TLMethod<TLUserFull> {
    public static final int CLASS_ID = 0xca30a5b1;
    protected InputUser id;

    public TLRequestUsersGetFullUser() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestUsersGetFullUser(InputUser id) {
        this.id = id;
    }

    @Override
    public TLUserFull deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLUserFull) {
            return (TLUserFull) res;
        }
        throw new IOException("Incorrect response type. Expected TLUserFull, got: " + res.getClass().getCanonicalName());
    }

    public InputUser getId() {
        return this.id;
    }

    public void setId(InputUser id) {
        this.id = id;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id = (InputUser) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "users.getFullUser#ca30a5b1";
    }
}