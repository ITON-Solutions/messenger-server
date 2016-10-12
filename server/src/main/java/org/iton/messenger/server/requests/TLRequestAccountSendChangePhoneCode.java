package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLAccountSentChangePhoneCode;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountSendChangePhoneCode extends TLMethod<TLAccountSentChangePhoneCode> {
    public static final int CLASS_ID = 0xa407a8f4;
    protected String phone_number;

    public TLRequestAccountSendChangePhoneCode() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountSendChangePhoneCode(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public TLAccountSentChangePhoneCode deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAccountSentChangePhoneCode))
            return (TLAccountSentChangePhoneCode) res;
        throw new IOException("Incorrect response type. Expected TLAccountSentChangePhoneCode, got: " + res.getClass().getCanonicalName());
    }

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.phone_number, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.phone_number = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.sendChangePhoneCode#a407a8f4";
    }
}
