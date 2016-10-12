package org.iton.messenger.api.contacts;

/**
 * Created by ITON Solutions on 8/9/16.
 */
public class TLContactLinkUnknown extends ContactLink {

    public static final int CLASS_ID = 0x5f4f9247;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString()
    {
        return "contact.LinkUnknown#5f4f9247";
    }
}
