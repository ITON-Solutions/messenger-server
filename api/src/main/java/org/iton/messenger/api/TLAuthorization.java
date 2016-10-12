package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAuthorization extends TLObject {
    public static final int CLASS_ID = 0x7bf2e6f6;

    protected long hash;
    protected int flags;
    protected String device_model;
    protected String platform;
    protected String system_version;
    protected int api_id;
    protected String app_name;
    protected String app_version;
    protected int date_created;
    protected int date_active;
    protected String ip;
    protected String country;
    protected String region;

    public TLAuthorization() {
    }

    public TLAuthorization(long hash,
                           int flags,
                           String device_model,
                           String platform,
                           String system_version,
                           int api_id,
                           String app_name,
                           String app_version,
                           int date_created,
                           int date_active,
                           String ip,
                           String country,
                           String region) {

        this.hash           = hash;
        this.flags          = flags;
        this.device_model   = device_model;
        this.platform       = platform;
        this.system_version = system_version;
        this.api_id         = api_id;
        this.app_name       = app_name;
        this.app_version    = app_version;
        this.date_created   = date_created;
        this.date_active    = date_active;
        this.ip             = ip;
        this.country        = country;
        this.region         = region;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getDeviceModel() {
        return device_model;
    }

    public void setDeviceModel(String device_model) {
        this.device_model = device_model;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSystemVersion() {
        return system_version;
    }

    public void setSystemVersion(String system_version) {
        this.system_version = system_version;
    }

    public int getApiId() {
        return api_id;
    }

    public void setApiId(int api_id) {
        this.api_id = api_id;
    }

    public String getAppName() {
        return app_name;
    }

    public void setAppName(String app_name) {
        this.app_name = app_name;
    }

    public String getAppVersion() {
        return app_version;
    }

    public void setAppVersion(String app_version) {
        this.app_version = app_version;
    }

    public int getDateCreated() {
        return date_created;
    }

    public void setDateCreated(int date_created) {
        this.date_created = date_created;
    }

    public int getDateActive() {
        return date_active;
    }

    public void setDateActive(int date_active) {
        this.date_active = date_active;
    }

    public String getIP() {
        return ip;
    }

    public void setIP(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.hash, stream);
        writeInt(this.flags, stream);
        writeTLString(this.device_model, stream);
        writeTLString(this.platform, stream);
        writeTLString(this.system_version, stream);
        writeInt(this.api_id, stream);
        writeTLString(this.app_name, stream);
        writeTLString(this.app_version, stream);
        writeInt(this.date_created, stream);
        writeInt(this.date_active, stream);
        writeTLString(this.ip, stream);
        writeTLString(this.country, stream);
        writeTLString(this.region, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {

        this.hash           = readLong(stream);
        this.flags          = readInt(stream);
        this.device_model   = readTLString(stream);
        this.platform       = readTLString(stream);
        this.system_version = readTLString(stream);
        this.api_id         = readInt(stream);
        this.app_name       = readTLString(stream);
        this.app_version    = readTLString(stream);
        this.date_created   = readInt(stream);
        this.date_active    = readInt(stream);
        this.ip             = readTLString(stream);
        this.country        = readTLString(stream);
        this.region         = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.Authorization#7bf2e6f6";
    }
}