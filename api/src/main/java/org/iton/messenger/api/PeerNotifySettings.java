package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class PeerNotifySettings extends TLObject
{
    protected int mute_until;
    protected String sound;
    protected boolean show_previews;
    protected int events_mask;

    public int getMuteUntil() {
        return mute_until;
    }

    public void setMuteUntil(int mute_until) {
        this.mute_until = mute_until;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public boolean isShowPreviews() {
        return show_previews;
    }

    public void setShowPreviews(boolean show_previews) {
        this.show_previews = show_previews;
    }

    public int getEventsMask() {
        return events_mask;
    }

    public void setEventsMask(int events_mask) {
        this.events_mask = events_mask;
    }
}
