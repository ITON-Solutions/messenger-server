package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.auth.TLAuthSentCode;

import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAuthSendCode extends TLMethod<TLAuthSentCode> {
    public static final int CLASS_ID = 0x768d5f4d;
    protected String phone_number;
    protected int sms_type;
    protected int api_id;
    protected String api_hash;
    protected String lang_code;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAuthSendCode() {
    }

    public TLRequestAuthSendCode(String phone_number, int sms_type, int api_id, String api_hash, String lang_code) {
        this.phone_number = phone_number;
        this.sms_type     = sms_type;
        this.api_id       = api_id;
        this.api_hash     = api_hash;
        this.lang_code    = lang_code;
    }

    @Override
    public TLAuthSentCode deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAuthSentCode))
            return (TLAuthSentCode) res;
        throw new IOException("Incorrect response type. Expected TLAuthSentCode, got: " + res.getClass().getCanonicalName());
    }

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getSmsType() {
        return this.sms_type;
    }

    public void setSmsType(int sms_type) {
        this.sms_type = sms_type;
    }

    public int getApiId() {
        return this.api_id;
    }

    public void setApiId(int api_id) {
        this.api_id = api_id;
    }

    public String getApiHash() {
        return this.api_hash;
    }

    public void setApiHash(String api_hash) {
        this.api_hash = api_hash;
    }

    public String getLangCode() {
        return this.lang_code;
    }

    public void setLangCode(String lang_code) {
        this.lang_code = lang_code;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.phone_number, stream);
        writeInt(this.sms_type, stream);
        writeInt(this.api_id, stream);
        writeTLString(this.api_hash, stream);
        writeTLString(this.lang_code, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_number = readTLString(stream);
        this.sms_type     = readInt(stream);
        this.api_id       = readInt(stream);
        this.api_hash     = readTLString(stream);
        this.lang_code    = readTLString(stream);
    }

    @Override
    public String toString() {
        return "auth.sendCode#768d5f4d";
    }
}