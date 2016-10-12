package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLConfig extends TLObject {


    public static final int CLASS_ID = 0x68bac247;

    protected int date;
    private int expires;
    private boolean test_mode;
    private int this_dc;
    private TLVector<TLDcOption> dc_options = new TLVector<>();
    private int chat_size_max;
    private int broadcast_size_max;
    private int forwarded_count_max;
    private int online_update_period_ms;
    private int offline_blur_timeout_ms;
    private int offline_idle_timeout_ms;
    private int online_cloud_timeout_ms;
    private int notify_cloud_delay_ms;
    private int notify_default_delay_ms;
    private int chat_big_size;
    private TLVector<TLDisabledFeature> disabled_features = new TLVector<>();

    public TLConfig() {
    }

    public TLConfig(int date,
                    int expires,
                    boolean test_mode,
                    int this_dc,
                    TLVector<TLDcOption> dc_options,
                    int chat_size_max,
                    int broadcast_size_max,
                    int forwarded_count_max,
                    int online_update_period_ms,
                    int offline_blur_timeout_ms,
                    int offline_idle_timeout_ms,
                    int online_cloud_timeout_ms,
                    int notify_cloud_delay_ms,
                    int notify_default_delay_ms,
                    int chat_big_size,
                    TLVector<TLDisabledFeature> disabled_features) {
        this.date = date;
        this.expires = expires;
        this.test_mode = test_mode;
        this.this_dc = this_dc;
        this.dc_options = dc_options;
        this.chat_size_max = chat_size_max;
        this.broadcast_size_max = broadcast_size_max;
        this.forwarded_count_max = forwarded_count_max;
        this.online_update_period_ms = online_update_period_ms;
        this.offline_blur_timeout_ms = offline_blur_timeout_ms;
        this.offline_idle_timeout_ms = offline_idle_timeout_ms;
        this.online_cloud_timeout_ms = online_cloud_timeout_ms;
        this.notify_cloud_delay_ms = notify_cloud_delay_ms;
        this.notify_default_delay_ms = notify_default_delay_ms;
        this.chat_big_size = chat_big_size;
        this.disabled_features = disabled_features;
    }


    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public boolean isTestMode() {
        return test_mode;
    }

    public void setTestMode(boolean test_mode) {
        this.test_mode = test_mode;
    }

    public int getThisDc() {
        return this_dc;
    }

    public void setThisDc(int this_dc) {
        this.this_dc = this_dc;
    }

    public TLVector<TLDcOption> getDcOptions() {
        return dc_options;
    }

    public void setDcOptions(TLVector<TLDcOption> dc_options) {
        this.dc_options = dc_options;
    }

    public int getChatSizeMax() {
        return chat_size_max;
    }

    public void setChatSizeMax(int chat_size_max) {
        this.chat_size_max = chat_size_max;
    }

    public int getBroadcastSizeMax() {
        return broadcast_size_max;
    }

    public void setBroadcastSizeMax(int broadcast_size_max) {
        this.broadcast_size_max = broadcast_size_max;
    }

    public int getForwardedCountMax() {
        return forwarded_count_max;
    }

    public void setForwardedCountMax(int forwarded_count_max) {
        this.forwarded_count_max = forwarded_count_max;
    }

    public int getOnlineUpdatePeriod() {
        return online_update_period_ms;
    }

    public void setOnlineUpdatePeriod(int online_update_period_ms) {
        this.online_update_period_ms = online_update_period_ms;
    }

    public int getOfflineBlurTimeout() {
        return offline_blur_timeout_ms;
    }

    public void setOfflineBlurTimeout(int offline_blur_timeout_ms) {
        this.offline_blur_timeout_ms = offline_blur_timeout_ms;
    }

    public int getOffline_idle_timeout_ms() {
        return offline_idle_timeout_ms;
    }

    public void setOfflineIdleTimeout(int offline_idle_timeout_ms) {
        this.offline_idle_timeout_ms = offline_idle_timeout_ms;
    }

    public int getOnlineCloudTimeout() {
        return online_cloud_timeout_ms;
    }

    public void setOnlineCloudTimeout(int online_cloud_timeout_ms) {
        this.online_cloud_timeout_ms = online_cloud_timeout_ms;
    }

    public int getNotifyCloudDelay() {
        return notify_cloud_delay_ms;
    }

    public void setNotifyCloudDelay(int notify_cloud_delay_ms) {
        this.notify_cloud_delay_ms = notify_cloud_delay_ms;
    }

    public int getNotifyDefaultDelay() {
        return notify_default_delay_ms;
    }

    public void setNotifyDefaultDelay(int notify_default_delay_ms) {
        this.notify_default_delay_ms = notify_default_delay_ms;
    }

    public int getChatBigSize() {
        return chat_big_size;
    }

    public void setChatBigSize(int chat_big_size) {
        this.chat_big_size = chat_big_size;
    }

    public TLVector<TLDisabledFeature> getDisabledFeatures() {
        return disabled_features;
    }

    public void setDisabledFeatures(TLVector<TLDisabledFeature> disabled_features) {
        this.disabled_features = disabled_features;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.date, stream);
        writeInt(this.expires, stream);
        writeTLBool(this.test_mode, stream);
        writeInt(this.this_dc, stream);
        writeTLVector(this.dc_options, stream);
        writeInt(this.chat_size_max, stream);
        writeInt(this.broadcast_size_max, stream);
        writeInt(this.forwarded_count_max, stream);
        writeInt(this.online_update_period_ms, stream);
        writeInt(this.offline_blur_timeout_ms, stream);
        writeInt(this.offline_idle_timeout_ms, stream);
        writeInt(this.online_cloud_timeout_ms, stream);
        writeInt(this.notify_cloud_delay_ms, stream);
        writeInt(this.notify_default_delay_ms, stream);
        writeInt(this.chat_big_size, stream);
        writeTLVector(this.disabled_features, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.date = readInt(stream);
        this.expires = readInt(stream);
        this.test_mode = readTLBool(stream);
        this.this_dc = readInt(stream);
        this.dc_options = readTLVector(stream, context);
        this.chat_size_max = readInt(stream);
        this.broadcast_size_max = readInt(stream);
        this.forwarded_count_max = readInt(stream);
        this.online_update_period_ms = readInt(stream);
        this.offline_blur_timeout_ms = readInt(stream);
        this.offline_idle_timeout_ms = readInt(stream);
        this.online_cloud_timeout_ms = readInt(stream);
        this.notify_cloud_delay_ms = readInt(stream);
        this.notify_default_delay_ms = readInt(stream);
        this.chat_big_size = readInt(stream);
        this.disabled_features = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "config#68bac247";
    }
}