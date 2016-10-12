package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountAuthorizations extends TLObject {
    public static final int CLASS_ID = 0x1250abde;

    protected TLVector<TLAuthorization> authorizations = null;

    public TLAccountAuthorizations() {
    }

    public TLAccountAuthorizations(TLVector<TLAuthorization> authorizations) {
        this.authorizations = authorizations;
    }

    public TLVector<TLAuthorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(TLVector<TLAuthorization> authorizations) {
        this.authorizations = authorizations;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.authorizations, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.authorizations = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "account.Authorizations#1250abde";
    }
}