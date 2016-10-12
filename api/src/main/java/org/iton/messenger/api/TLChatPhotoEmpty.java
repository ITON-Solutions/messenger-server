package org.iton.messenger.api;


public class TLChatPhotoEmpty extends ChatPhoto {
    public static final int CLASS_ID = 0x37c1011c;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "chatPhotoEmpty#37c1011c";
    }
}
