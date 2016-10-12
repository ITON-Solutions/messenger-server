package org.iton.messenger.api;

public class TLMessageMediaEmpty extends MessageMedia {
    public static final int CLASS_ID = 0x3ded6320;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "message.mediaEmpty#3ded6320";
    }
}
