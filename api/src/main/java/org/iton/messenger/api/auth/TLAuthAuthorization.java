package org.iton.messenger.api.auth;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAuthAuthorization extends TLObject {
    public static final int CLASS_ID = 0xf6b673a4;
    protected int expires;
    protected User user;

    public TLAuthAuthorization() {
    }

    public TLAuthAuthorization(int expires, User user) {
        this.expires = expires;
        this.user    = user;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getExpires() {
        return this.expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeInt(this.expires, buf);
        writeTLObject(this.user, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        this.expires = readInt(buf);
        this.user    = (User) readTLObject(buf, context);
    }

    @Override
    public String toString() {
        return "auth.Authorization#f6b673a4";
    }
}