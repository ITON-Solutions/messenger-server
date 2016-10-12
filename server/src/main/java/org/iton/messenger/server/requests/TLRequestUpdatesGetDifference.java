package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.updates.Difference;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestUpdatesGetDifference extends TLMethod<Difference> {
    public static final int CLASS_ID = 0xa041495;

    protected int pts;
    protected int date;
    protected int qts;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestUpdatesGetDifference(){}

    public TLRequestUpdatesGetDifference(int pts, int date, int qts) {
        this.pts  = pts;
        this.date = date;
        this.qts  = qts;
    }

    @Override
    public Difference deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof Difference)
            return (Difference) res;
        throw new IOException("Incorrect response type. Expected Difference, got: " + res.getClass().getCanonicalName());
    }

    public int getPts() {
        return this.pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getQts() {
        return this.qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.pts, stream);
        writeInt(this.date, stream);
        writeInt(this.qts, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.pts  = readInt(stream);
        this.date = readInt(stream);
        this.qts  = readInt(stream);
    }

    @Override
    public String toString() {
        return "updates.getDifference#a041495";
    }
}