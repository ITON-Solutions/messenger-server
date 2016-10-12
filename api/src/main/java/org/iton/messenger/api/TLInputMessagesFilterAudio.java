package org.iton.messenger.api;


public class TLInputMessagesFilterAudio extends MessagesFilter {
    public static final int CLASS_ID = 0xcfc87522;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "input.messagesFilterAudio#cfc87522";
    }
}