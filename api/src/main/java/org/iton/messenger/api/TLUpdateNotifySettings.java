package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLObject;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLObject;

public class TLUpdateNotifySettings extends Update {
    public static final int CLASS_ID = 0xbec268ef;

    public TLUpdateNotifySettings() {
    }

    public TLUpdateNotifySettings(NotifyPeer peer, PeerNotifySettings notify_settings) {
        this.peer            = peer;
        this.notify_settings = notify_settings;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.peer, stream);
        writeTLObject(this.notify_settings, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.peer            = (NotifyPeer) readTLObject(stream, context);
        this.notify_settings = (PeerNotifySettings) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "update.notifySettings#bec268ef";
    }
}