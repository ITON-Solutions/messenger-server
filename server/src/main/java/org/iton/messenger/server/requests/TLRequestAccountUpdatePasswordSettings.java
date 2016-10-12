package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLAccountPasswordInputSettings;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountUpdatePasswordSettings extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xfa7c4b86;

    protected byte[] current_password_hash;
    protected TLAccountPasswordInputSettings new_settings;

    public TLRequestAccountUpdatePasswordSettings(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLBool deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLBool))
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
    }

    public byte[] getCurrentPasswordHash() {
        return current_password_hash;
    }

    public void setCurrentPasswordHash(byte[] current_password_hash) {
        this.current_password_hash = current_password_hash;
    }

    public TLAccountPasswordInputSettings getNewSettings() {
        return new_settings;
    }

    public void setNewSettings(TLAccountPasswordInputSettings new_settings) {
        this.new_settings = new_settings;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLBytes(this.current_password_hash, stream);
        writeTLObject(this.new_settings, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.current_password_hash = readTLBytes(stream);
        this.new_settings          = (TLAccountPasswordInputSettings) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "account.updatePasswordSettings#fa7c4b86";
    }

}
