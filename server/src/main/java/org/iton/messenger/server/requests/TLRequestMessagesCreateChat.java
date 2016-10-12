package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputUser;
import org.iton.messenger.api.updates.Updates;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;


import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesCreateChat extends TLMethod<Updates> {
    public static final int CLASS_ID = 0x9cb126e;
    protected TLVector<InputUser> users;
    protected String title;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesCreateChat() {}

    public TLRequestMessagesCreateChat(TLVector<InputUser> users, String title) {
        this.users = users;
        this.title = title;
    }

    @Override
    public Updates deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof Updates))
            return (Updates) res;
        throw new IOException("Incorrect response type. Expected Updates, got: " + res.getClass().getCanonicalName());
    }

    public TLVector<InputUser> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<InputUser> users) {
        this.users = users;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.users, stream);
        writeTLString(this.title, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.users = readTLVector(stream, context);
        this.title = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messages.createChat#9cb126e";
    }
}