package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.TLAccountPrivacyRules;
import org.iton.messenger.api.TLInputPrivacyKeyStatusTimestamp;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLObject;

public class TLRequestAccountGetPrivacy extends TLMethod<TLAccountPrivacyRules> {

    public static final int CLASS_ID = 0xdadbc950;

    protected TLInputPrivacyKeyStatusTimestamp key;

    public TLRequestAccountGetPrivacy(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLAccountPrivacyRules deserializeResponse(ByteBuf buf, TLContext context) throws IOException {
        TLObject res = readTLObject(buf, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAccountPrivacyRules))
            return (TLAccountPrivacyRules) res;
        throw new IOException("Incorrect response type. Expected TLAccountTTL, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.key, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.key = (TLInputPrivacyKeyStatusTimestamp) readTLObject(stream, context);
    }

    public TLInputPrivacyKeyStatusTimestamp getKey() {
        return key;
    }

    public void setKey(TLInputPrivacyKeyStatusTimestamp key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "account.getPrivacy#dadbc950";
    }
}
