package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestAccountResetAuthorization extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0xdf77f3bc;
    protected long hash;


    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountResetAuthorization(long hash) {
        this.hash = hash;
    }


    public TLRequestAccountResetAuthorization() {
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
        if ((res instanceof TLBool))
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected org.telegram.server.tl.TLBool, got: " + res.getClass().getCanonicalName());
    }

    public long getHash() {
        return this.hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.hash = readLong(stream);
    }

    @Override
    public String toString() {
        return "account.resetAuthorization#df77f3bc";
    }
}