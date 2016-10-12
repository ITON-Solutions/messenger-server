package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class WallPaper extends TLObject {
    protected int id;
    protected String title;
    protected TLVector<PhotoSize> sizes = new TLVector<>();
    protected int color;
    protected int bg_color;

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

    public TLVector<PhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(TLVector<PhotoSize> sizes) {
        this.sizes = sizes;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBgColor() {
        return bg_color;
    }

    public void setBgColor(int bg_color) {
        this.bg_color = bg_color;
    }
}