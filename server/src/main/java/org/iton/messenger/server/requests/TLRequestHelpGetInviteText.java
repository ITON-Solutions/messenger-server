package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.help.TLInviteText;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestHelpGetInviteText extends TLMethod<TLInviteText> {
    public static final int CLASS_ID = 0xa4a95186;
    protected String lang_code;

    public TLRequestHelpGetInviteText() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestHelpGetInviteText(String lang_code) {
        this.lang_code = lang_code;
    }

    @Override
    public TLInviteText deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLInviteText))
            return (TLInviteText) res;
        throw new IOException("Incorrect response type. Expected TLInviteText, got: " + res.getClass().getCanonicalName());
    }

    public String getLangCode() {
        return this.lang_code;
    }

    public void setLangCode(String lang_code) {
        this.lang_code = lang_code;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.lang_code, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.lang_code = readTLString(stream);
    }

    @Override
    public String toString() {
        return "help.getInviteText#a4a95186";
    }
}