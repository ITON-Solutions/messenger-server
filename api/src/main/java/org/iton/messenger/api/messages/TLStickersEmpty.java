package org.iton.messenger.api.messages;

public class TLStickersEmpty extends Stickers {
    public static final int CLASS_ID = 0xe86602c3;

    public TLStickersEmpty() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "messages.stickersEmpty#e86602c3";
    }
}