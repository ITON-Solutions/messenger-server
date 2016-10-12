package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountNoPassword extends AccountPassword {
    public static final int CLASS_ID = 0x96dabc18;

    public TLAccountNoPassword() {
    }

    public TLAccountNoPassword(byte[] new_salt, String email_unconfirmed_pattern) {
        this.new_salt                  = new_salt;
        this.email_unconfirmed_pattern = email_unconfirmed_pattern;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLBytes(this.new_salt, stream);
        writeTLString(this.email_unconfirmed_pattern, stream);;
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.new_salt                  = readTLBytes(stream);
        this.email_unconfirmed_pattern = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.noPassword#96dabc18";
    }
}