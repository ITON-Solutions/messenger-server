package org.iton.messenger.api;

public class TLSendMessageGeoLocationAction extends SendMessageAction {
    public static final int CLASS_ID = 0x176f8ba1;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "send.message.GeoLocationAction#176f8ba1";
    }
}
