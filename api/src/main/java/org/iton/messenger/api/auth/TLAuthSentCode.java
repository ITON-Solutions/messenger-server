package org.iton.messenger.api.auth;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAuthSentCode extends TLObject {
    public static final int CLASS_ID = 0xefed51d9;
    protected boolean phoneRegistered;
    protected String phoneCodeHash;
    protected int sendCallTimeout;
    protected boolean isPassword;

    public TLAuthSentCode() {
    }

    public TLAuthSentCode(boolean _phoneRegistered, String _phoneCodeHash, int _sendCallTimeout, boolean _isPassword) {
        this.phoneRegistered = _phoneRegistered;
        this.phoneCodeHash = _phoneCodeHash;
        this.sendCallTimeout = _sendCallTimeout;
        this.isPassword = _isPassword;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public boolean getPhoneRegistered() {
        return this.phoneRegistered;
    }

    public void setPhoneRegistered(boolean value) {
        this.phoneRegistered = value;
    }

    public String getPhoneCodeHash() {
        return this.phoneCodeHash;
    }

    public void setPhoneCodeHash(String value) {
        this.phoneCodeHash = value;
    }

    public int getSendCallTimeout() {
        return this.sendCallTimeout;
    }

    public void setSendCallTimeout(int value) {
        this.sendCallTimeout = value;
    }

    public boolean getIsPassword() {
        return this.isPassword;
    }

    public void setIsPassword(boolean value) {
        this.isPassword = value;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        writeTLBool(this.phoneRegistered, buf);
        writeTLString(this.phoneCodeHash, buf);
        writeInt(this.sendCallTimeout, buf);
        writeTLBool(this.isPassword, buf);
    }

    @Override
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {
        this.phoneRegistered = readTLBool(buf);
        this.phoneCodeHash = readTLString(buf);
        this.sendCallTimeout = readInt(buf);
        this.isPassword = readTLBool(buf);
    }

    @Override
    public String toString() {
        return "auth.sentCode#efed51d9";
    }
}