package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Photo extends TLObject {
    protected long id;
    protected long access_hash;
    protected int user_id;
    protected int date;
    protected String caption;
    protected GeoPoint geo_point;
    protected TLVector<PhotoSize> sizes = new TLVector<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return access_hash;
    }

    public void setAccessHash(long access_hash) {
        this.access_hash = access_hash;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public GeoPoint getGeoPoint() {
        return geo_point;
    }

    public void setGeoPoint(GeoPoint geo_point) {
        this.geo_point = geo_point;
    }

    public TLVector<PhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(TLVector<PhotoSize> sizes) {
        this.sizes = sizes;
    }
}
