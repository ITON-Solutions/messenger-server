package org.iton.messenger.api;


public class TLInputPhotoEmpty extends InputPhoto {
    public static final int CLASS_ID = 0x1cd7bf0d;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "input.photoEmpty#1cd7bf0d";
    }
}
