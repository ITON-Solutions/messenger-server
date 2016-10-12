package org.iton.messenger.api;

public class TLSendMessageTypingAction extends SendMessageAction {
    public static final int CLASS_ID = 0x16bf744e;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.TypingAction#16bf744e";
    }
}
