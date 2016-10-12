package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountRegisterDevice extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0x446c712c;
    protected int token_type;
    protected String token;
    protected String device_model;
    protected String system_version;
    protected String app_version;
    protected boolean app_sandbox;
    protected String lang_code;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountRegisterDevice(int token_type,
                                          String token,
                                          String device_model,
                                          String system_version,
                                          String app_version,
                                          boolean app_sandbox,
                                          String lang_code) {
        this.token_type     = token_type;
        this.token          = token;
        this.device_model   = device_model;
        this.system_version = system_version;
        this.app_version    = app_version;
        this.app_sandbox    = app_sandbox;
        this.lang_code      = lang_code;
    }


    public TLRequestAccountRegisterDevice() {
    }

    /**
     * @param stream
     * @param context
     * @return
     * @throws IOException
     */
    @Override
    public TLBool deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof TLBool)
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected org.telegram.server.tl.TLBool, got: " + res.getClass().getCanonicalName());
    }

    public int getTokenType() {
        return this.token_type;
    }

    public void setTokenType(int token_type) {
        this.token_type = token_type;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String value) {
        this.token = value;
    }

    public String getDeviceModel() {
        return this.device_model;
    }

    public void setDeviceModel(String device_model) {
        this.device_model = device_model;
    }

    public String getSystemVersion() {
        return this.system_version;
    }

    public void setSystemVersion(String system_version) {
        this.system_version = system_version;
    }

    public String getAppVersion() {
        return this.app_version;
    }

    public void setAppVersion(String app_version) {
        this.app_version = app_version;
    }

    public boolean getAppSandbox() {
        return this.app_sandbox;
    }

    public void setAppSandbox(boolean app_sandbox) {
        this.app_sandbox = app_sandbox;
    }

    public String getLangCode() {
        return this.lang_code;
    }

    public void setLangCode(String lang_code) {
        this.lang_code = lang_code;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.token_type, stream);
        writeTLString(this.token, stream);
        writeTLString(this.device_model, stream);
        writeTLString(this.system_version, stream);
        writeTLString(this.app_version, stream);
        writeTLBool(this.app_sandbox, stream);
        writeTLString(this.lang_code, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.token_type     = readInt(stream);
        this.token          = readTLString(stream);
        this.device_model   = readTLString(stream);
        this.system_version = readTLString(stream);
        this.app_version    = readTLString(stream);
        this.app_sandbox    = readTLBool(stream);
        this.lang_code      = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.registerDevice#446c712c";
    }
}