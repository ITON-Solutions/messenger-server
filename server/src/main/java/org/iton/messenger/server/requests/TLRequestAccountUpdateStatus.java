package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLBool;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLRequestAccountUpdateStatus extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0x6628562c;
    protected boolean offline;

    public TLRequestAccountUpdateStatus() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestAccountUpdateStatus(boolean offline) {
        this.offline = offline;
    }

    @Override
    public TLBool deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLBool))
            return (TLBool) res;
        throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
    }

    public boolean isOffline() {
        return this.offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLBool(this.offline, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.offline = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "account.updateStatus#6628562c";
    }
}