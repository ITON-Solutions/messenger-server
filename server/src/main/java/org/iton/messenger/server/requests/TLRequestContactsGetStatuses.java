package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.TLContactStatus;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestContactsGetStatuses extends TLMethod<TLVector<TLObject>> {
    public static final int CLASS_ID = 0xc4a353ee;

    protected TLVector<TLContactStatus> id;

    public TLRequestContactsGetStatuses() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLContactStatus> getId() {
        return id;
    }

    public void setId(TLVector<TLContactStatus> id) {
        this.id = id;
    }

    @Override
    public TLVector<TLObject> deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

//    @Override
//    public void serializeBody(ByteBuf stream) throws IOException {
//        writeTLVector(this.id, stream);
//    }
//
//    @Override
//    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
//        this.id = readTLVector(stream, context);
//    }

    @Override
    public String toString() {
        return "contacts.getStatuses#c4a353ee";
    }
}