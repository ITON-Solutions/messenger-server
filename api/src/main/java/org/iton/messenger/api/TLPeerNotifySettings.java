package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPeerNotifySettings extends PeerNotifySettings {

    public static final int CLASS_ID = 0x8d5e11ee;

    public TLPeerNotifySettings() {
    }

    public TLPeerNotifySettings(int mute_until, String sound, boolean show_previews, int events_mask) {
        this.mute_until    = mute_until;
        this.sound         = sound;
        this.show_previews = show_previews;
        this.events_mask   = events_mask;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.mute_until, stream);
        writeTLString(this.sound, stream);
        writeTLBool(this.show_previews, stream);
        writeInt(this.events_mask, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.mute_until    = readInt(stream);
        this.sound         = readTLString(stream);
        this.show_previews = readTLBool(stream);
        this.events_mask   = readInt(stream);
    }

    @Override
    public String toString() {
        return "peerNotifySettings#8d5e11ee";
    }
}