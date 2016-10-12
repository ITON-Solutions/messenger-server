package org.iton.messenger.api;

public class TLSendMessageUploadVideoAction extends SendMessageAction {
    public static final int CLASS_ID = 0x92042ff7;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.UploadVideoAction#92042ff7";
    }
}
