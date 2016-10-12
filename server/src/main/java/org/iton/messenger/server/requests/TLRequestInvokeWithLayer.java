package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestInvokeWithLayer extends TLMethod<TLObject>
{
    protected static final int LAYER = 27;
    public static final int CLASS_ID = 0xda9b0d0d;

    protected int layer = LAYER;
    protected TLMethod query;

    public int getClassId()
    {
        return CLASS_ID;
    }

    public TLRequestInvokeWithLayer()
    {
    }

    public TLRequestInvokeWithLayer(TLMethod query)
    {
        this.query = query;
    }

    public TLObject deserializeResponse(ByteBuf stream, TLContext context) throws IOException
    {
        return this.query.deserializeResponse(stream, context);
    }

    public TLMethod getQuery()
    {
        return this.query;
    }

    public void setQuery(TLMethod query)
    {
        this.query = query;
    }

    public void setLayer(int layer)
    {
        this.layer = layer;
    }

    public int getLayer()
    {
        return this.layer;
    }



    public void serializeBody(ByteBuf stream) throws IOException
    {
        writeInt(this.layer, stream);
        writeTLMethod(this.query, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException
    {
        this.layer = readInt(stream);
        this.query = readTLMethod(stream, context);
    }

    public String toString()
    {
        return "invokeWithLayer#da9b0d0d";
    }
}