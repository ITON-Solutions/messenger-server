package org.iton.messenger.api;

public class TLSendMessageChooseContactAction extends SendMessageAction {
    public static final int CLASS_ID = 0x628cbc6f;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.ChooseContactAction#628cbc6f";
    }
}
