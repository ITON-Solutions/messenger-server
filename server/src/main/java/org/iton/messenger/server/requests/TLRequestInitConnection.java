package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestInitConnection extends TLMethod<TLObject>
{
    public static final int CLASS_ID = 0x69796de9;
    protected int api_id;
    protected String device_model;
    protected String system_version;
    protected String app_version;
    protected String lang_code;
    protected TLMethod query;

    @Override
    public int getClassId()
    {
        return CLASS_ID;
    }

    public TLRequestInitConnection(int api_id,
                                   String device_model,
                                   String system_version,
                                   String app_version,
                                   String lang_code,
                                   TLMethod query)
    {
        this.api_id         = api_id;
        this.device_model   = device_model;
        this.system_version = system_version;
        this.app_version    = app_version;
        this.lang_code      = lang_code;
        this.query          = query;
    }

    public TLRequestInitConnection(){}

    @Override
    public TLObject deserializeResponse(ByteBuf stream, TLContext context) throws IOException
    {
        return this.query.deserializeResponse(stream, context);
    }

    public int getApiId()
    {
        return this.api_id;
    }

    public void setApiId(int api_id)
    {
        this.api_id = api_id;
    }

    public String getDeviceModel()
    {
        return this.device_model;
    }

    public void setDeviceModel(String device_model)
    {
        this.device_model = device_model;
    }

    public String getSystemVersion()
    {
        return this.system_version;
    }

    public void setSystemVersion(String system_version)
    {
        this.system_version = system_version;
    }

    public String getAppVersion()
    {
        return this.app_version;
    }

    public void setAppVersion(String app_version)
    {
        this.app_version = app_version;
    }

    public String getLangCode()
    {
        return this.lang_code;
    }

    public void setLangCode(String lang_code)
    {
        this.lang_code = lang_code;
    }

    public TLMethod getQuery()
    {
        return this.query;
    }

    public void setQuery(TLMethod value)
    {
        this.query = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException
    {
        writeInt(this.api_id, stream);
        writeTLString(this.device_model, stream);
        writeTLString(this.system_version, stream);
        writeTLString(this.app_version, stream);
        writeTLString(this.lang_code, stream);
        writeTLMethod(this.query, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException
    {
        this.api_id         = readInt(stream);
        this.device_model   = readTLString(stream);
        this.system_version = readTLString(stream);
        this.app_version    = readTLString(stream);
        this.lang_code      = readTLString(stream);
        this.query          = readTLMethod(stream, context);
    }

    @Override
    public String toString()
    {
        return "#69796de9";
    }
}