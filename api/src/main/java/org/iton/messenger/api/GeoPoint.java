package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class GeoPoint extends TLObject
{
    protected double lng;
    protected double lat;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
