package org.iton.messenger.api;

public class TLSendMessageUploadPhotoAction extends SendMessageAction {
    public static final int CLASS_ID = 0x990a3c1a;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.UploadPhotoAction#990a3c1a";
    }
}
