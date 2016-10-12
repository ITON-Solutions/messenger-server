package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLFutureSalts extends TLObject {
    public static final int CLASS_ID = 0xae500895;

    private long requestId;
    private int now;
    private TLVector<TLFutureSalt> salts = new TLVector<TLFutureSalt>();

    public TLFutureSalts(long requestId, int now, TLVector<TLFutureSalt> salts) {
        this.requestId = requestId;
        this.now = now;
        this.salts = salts;
    }

    public TLFutureSalts() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getRequestId() {
        return requestId;
    }

    public int getNow() {
        return now;
    }

    public TLVector<TLFutureSalt> getSalts() {
        return salts;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(requestId, stream);
        writeInt(now, stream);
        writeInt(salts.size(), stream);
        for (TLFutureSalt salt : salts) {
            salt.serializeBody(stream);
        }
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        requestId = readLong(stream);
        now = readInt(stream);
        int count = readInt(stream);
        salts.clear();
        for (int i = 0; i < count; i++) {
            TLFutureSalt salt = new TLFutureSalt();
            salt.deserializeBody(stream, context);
            salts.add(salt);
        }
    }

    @Override
    public String toString() {
        return "future_salts#ae500895";
    }
}
