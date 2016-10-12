package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class InputGeoPoint extends TLObject
{
    protected double lat;
    protected double lng;

    public double getLatitude() {
        return lat;
    }

    public void setLatitude(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return lng;
    }

    public void setLongitude(double lng) {
        this.lng = lng;
    }
}
