package org.iton.messenger.api;

public class TLSendMessageCancelAction extends SendMessageAction {
    public static final int CLASS_ID = 0xfd5ec8f5;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.CancelAction#fd5ec8f5";
    }
}
