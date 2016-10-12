package org.iton.messenger.api.contacts;

/**
 * Created by ITON Solutions on 8/9/16.
 */
public class TLContactLinkHasPhone extends ContactLink {

    public static final int CLASS_ID = 0x268f3f59;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString()
    {
        return "contact.LinkHasPhone#268f3f59";
    }
}
