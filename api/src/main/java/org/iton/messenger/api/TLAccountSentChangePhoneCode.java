package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountSentChangePhoneCode extends TLObject {

    public static final int CLASS_ID = 0xa4f58c4c;
    protected String phone_code_hash;
    protected int send_call_timeout;

    public TLAccountSentChangePhoneCode() {
    }

    public TLAccountSentChangePhoneCode(String phone_code_hash, int send_call_timeout) {
        this.phone_code_hash   = phone_code_hash;
        this.send_call_timeout = send_call_timeout;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getPhoneCodeHash() {
        return phone_code_hash;
    }

    public void setPhoneCodeHash(String phone_code_hash) {
        this.phone_code_hash = phone_code_hash;
    }

    public int getSendCallTimeout() {
        return send_call_timeout;
    }

    public void setSendCallTimeout(int send_call_timeout) {
        this.send_call_timeout = send_call_timeout;
    }

    @Override
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeTLString(this.phone_code_hash, stream);
        writeInt(this.send_call_timeout, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_code_hash   = readTLString(stream);
        this.send_call_timeout = readInt(stream);
    }

    @Override
    public String toString() {
        return "account.sentChangePhoneCode#a4f58c4c";
    }

}
