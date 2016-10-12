package org.iton.messenger.api;


import org.iton.messenger.core.TLObject;

public class TLInputPrivacyKeyStatusTimestamp extends TLObject {
    public static final int CLASS_ID = 0x4f96cb18;

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "input.privacyKeyStatusTimestamp#4f96cb18";
    }
}
