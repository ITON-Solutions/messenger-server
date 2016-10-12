package org.iton.messenger.api;

public class TLSendMessageUploadDocumentAction extends SendMessageAction {
    public static final int CLASS_ID = 0x8faee98e;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.UploadDocumentAction#8faee98e";
    }
}
