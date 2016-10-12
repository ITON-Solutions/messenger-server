package org.iton.messenger.api;


public class TLInputMessagesFilterVideo extends MessagesFilter {
    public static final int CLASS_ID = 0x9fc00e65;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "input.messagesFilterVideo#9fc00e65";
    }
}