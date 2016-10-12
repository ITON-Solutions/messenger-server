package org.iton.messenger.api;


public class TLPrivacyKeyStatusTimestamp extends MessagesFilter {
    public static final int CLASS_ID = 0xbc2eab30;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "privacyKeyStatusTimestamp#bc2eab30";
    }
}