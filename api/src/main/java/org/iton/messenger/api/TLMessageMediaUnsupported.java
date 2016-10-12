package org.iton.messenger.api;

public class TLMessageMediaUnsupported extends MessageMedia {
    public static final int CLASS_ID = 0x9f84f49e;

    public TLMessageMediaUnsupported() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public String toString() {
        return "message.mediaUnsupported#9f84f49e";
    }
}