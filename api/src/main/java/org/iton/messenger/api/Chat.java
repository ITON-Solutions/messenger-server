package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class Chat extends TLObject {
    protected int id;
    protected String title;
    protected int date;
    protected long access_hash;
    protected String address;
    protected String venue;
    protected GeoPoint geo;
    protected ChatPhoto photo;
    protected int participants_count;
    protected boolean checked_in;
    protected int version;
    protected boolean left;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getAccessHash() {
        return access_hash;
    }

    public void setAccessHash(long access_hash) {
        this.access_hash = access_hash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public GeoPoint getGeo() {
        return geo;
    }

    public void setGeo(GeoPoint geo) {
        this.geo = geo;
    }

    public ChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(ChatPhoto photo) {
        this.photo = photo;
    }

    public int getParticipantsCount() {
        return participants_count;
    }

    public void setParticipantsCount(int participants_count) {
        this.participants_count = participants_count;
    }

    public boolean isCheckedIn() {
        return checked_in;
    }

    public void setCheckedIn(boolean checked_in) {
        this.checked_in = checked_in;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
