package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class InputPhotoCrop extends TLObject
{
    protected double crop_left;
    protected double crop_top;
    protected double crop_width;

    public double getCropLeft() {
        return crop_left;
    }

    public void setCropLeft(double crop_left) {
        this.crop_left = crop_left;
    }

    public double getCropTop() {
        return crop_top;
    }

    public void setCropTop(double crop_top) {
        this.crop_top = crop_top;
    }

    public double getCropWidth() {
        return crop_width;
    }

    public void setCropWidth(double crop_width) {
        this.crop_width = crop_width;
    }
}
