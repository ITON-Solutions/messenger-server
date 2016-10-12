package org.iton.messenger.api;

public class TLSendMessageRecordVideoAction extends SendMessageAction {
    public static final int CLASS_ID = 0xa187d66f;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.RecordVideoAction#a187d66f";
    }
}
