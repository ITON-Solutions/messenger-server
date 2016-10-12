package org.iton.messenger.api.auth;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLAuthPasswordRecovery extends TLObject {
    public static final int CLASS_ID = 0x137948a5;

    protected String email_pattern;

    public TLAuthPasswordRecovery() {
    }

    public TLAuthPasswordRecovery(String email_pattern) {
        this.email_pattern = email_pattern;
    }

    public String getEmailPattern() {
        return email_pattern;
    }

    public void setEmailPattern(String email_pattern) {
        this.email_pattern = email_pattern;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }



    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.email_pattern, stream);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        this.email_pattern = readTLString(buf);
    }

    @Override
    public String toString() {
        return "auth.passwordRecovery#137948a5";
    }
}