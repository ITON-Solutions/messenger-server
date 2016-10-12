package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountPasswordSettings extends TLObject {
    public static final int CLASS_ID = 0xb7b72ab3;

    protected String email = null;

    public TLAccountPasswordSettings() {
    }

    public TLAccountPasswordSettings(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.email, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.email = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.passwordSettings#b7b72ab3";
    }
}