package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountPasswordInputSettings extends TLObject {
    public static final int CLASS_ID = 0xbcfc532c;

    protected int flags;
    protected byte[] new_salt;
    protected byte[] new_password_hash;
    protected String hint;
    protected String email;

    public TLAccountPasswordInputSettings() {
    }

    public TLAccountPasswordInputSettings(int flags, byte[] new_salt, byte[] new_password_hash, String hint, String email) {
        this.flags             = flags;
        this.new_salt          = new_salt;
        this.new_password_hash = new_password_hash;
        this.hint              = hint;
        this.email             = email;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public byte[] getNewSalt() {
        return new_salt;
    }

    public void setNewSalt(byte[] new_salt) {
        this.new_salt = new_salt;
    }

    public byte[] getNewPasswordHash() {
        return new_password_hash;
    }

    public void setNewPasswordHash(byte[] new_password_hash) {
        this.new_password_hash = new_password_hash;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
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
        writeInt(this.flags, stream);

        if ((flags & 1) != 0) {
            writeTLBytes(this.new_salt, stream);
            writeTLBytes(this.new_password_hash, stream);
            writeTLString(this.hint, stream);
        }
        if ((flags & 2) != 0) {
            writeTLString(this.email, stream);
        }
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.flags = readInt(stream);

        if ((this.flags & 1) != 0) {
            this.new_salt          = readTLBytes(stream);
            this.new_password_hash = readTLBytes(stream);
            this.hint              = readTLString(stream);
        }
        if ((flags & 2) != 0) {
            this.email = readTLString(stream);
        }
    }

    @Override
    public String toString() {
        return "account.passwordInputSettings#0xbcfc532c";
    }
}