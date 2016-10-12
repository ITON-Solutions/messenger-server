package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLAccountPasswordSettings;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountGetPasswordSettings extends TLMethod<TLAccountPasswordSettings> {

    public static final int CLASS_ID = 0xbc8d11bb;

    protected byte[] current_password_hash;

    public TLRequestAccountGetPasswordSettings(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLAccountPasswordSettings deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAccountPasswordSettings))
            return (TLAccountPasswordSettings) res;
        throw new IOException("Incorrect response type. Expected TLAccountPasswordSettings, got: " + res.getClass().getCanonicalName());
    }

    public byte[] getCurrentPasswordHash() {
        return current_password_hash;
    }

    public void setCurrentPasswordHash(byte[] current_password_hash) {
        this.current_password_hash = current_password_hash;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLBytes(this.current_password_hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.current_password_hash = readTLBytes(stream);
    }

    @Override
    public String toString() {
        return "account.getPasswordSettings#bc8d11bb";
    }
}
