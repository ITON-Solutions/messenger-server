package org.iton.messenger.api;


public class TLInputMediaEmpty extends InputMedia {
    public static final int CLASS_ID = 0x9664f57f;

    public int getClassId() {
        return -CLASS_ID;
    }

    public String toString() {
        return "input.mediaEmpty#9664f57f";
    }
}
