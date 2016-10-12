package org.iton.messenger.api.contacts;

/**
 * Created by ITON Solutions on 8/9/16.
 */
public class TLContactsNotModified extends Contacts {

    public static final int CLASS_ID = 0xb74ba9d2;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString()
    {
        return "contacts.notModified#b74ba9d2";
    }
}
