package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.*;
import org.iton.messenger.core.utils.StreamingUtils;

import java.io.IOException;

public class TLRequestAuthSendCall extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0x3c51564;
    protected String phoneNumber;
    protected String phoneCodeHash;

    public TLRequestAuthSendCall() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAuthSendCall(String _phoneNumber, String _phoneCodeHash) {
        this.phoneNumber = _phoneNumber;
        this.phoneCodeHash = _phoneCodeHash;
    }

    @Override
    public TLBool deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLBool))
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public String getPhoneCodeHash() {
        return this.phoneCodeHash;
    }

    public void setPhoneCodeHash(String value) {
        this.phoneCodeHash = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        StreamingUtils.writeTLString(this.phoneNumber, stream);
        StreamingUtils.writeTLString(this.phoneCodeHash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context)
            throws IOException {
        this.phoneNumber = StreamingUtils.readTLString(stream);
        this.phoneCodeHash = StreamingUtils.readTLString(stream);
    }

    @Override
    public String toString() {
        return "auth.sendCall#3c51564";
    }
}