package org.iton.messenger.api.contacts;

/**
 * Created by ITON Solutions on 8/9/16.
 */
public class TLContactLinkContact extends ContactLink {

    public static final int CLASS_ID = 0xd502c2d0;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString()
    {
        return "contact.LinkContact#d502c2d0";
    }
}
