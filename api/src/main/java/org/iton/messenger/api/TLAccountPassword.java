package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountPassword extends AccountPassword {
    public static final int CLASS_ID = 0x7c18141c;

    public TLAccountPassword() {
    }

    public TLAccountPassword(byte[] current_salt, byte[] new_salt, String hint, boolean has_recovery, String email_unconfirmed_pattern) {
        this.current_salt              = current_salt;
        this.new_salt                  = new_salt;
        this.hint                      = hint;
        this.has_recovery              = has_recovery;
        this.email_unconfirmed_pattern = email_unconfirmed_pattern;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLBytes(this.current_salt, stream);
        writeTLBytes(this.new_salt, stream);
        writeTLString(this.hint, stream);
        writeTLBool(this.has_recovery, stream);
        writeTLString(this.email_unconfirmed_pattern, stream);;
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.current_salt              = readTLBytes(stream);
        this.new_salt                  = readTLBytes(stream);
        this.hint                      = readTLString(stream);
        this.has_recovery              = readTLBool(stream);
        this.email_unconfirmed_pattern = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.Password#7c18141c";
    }
}