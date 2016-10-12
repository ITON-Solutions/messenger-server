package org.iton.messenger.api;

public class TLSendMessageRecordAudioAction extends SendMessageAction {
    public static final int CLASS_ID = 0xd52f73f7;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.RecordAudioAction#d52f73f7";
    }
}
