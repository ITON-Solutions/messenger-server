package org.iton.messenger.api.contacts;

/**
 * Created by ITON Solutions on 8/9/16.
 */
public class TLContactLinkNone extends ContactLink {

    public static final int CLASS_ID = 0xfeedd3ad;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString()
    {
        return "contact.LinkNone#feedd3ad";
    }
}
