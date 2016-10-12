package org.iton.messenger.api;

public class TLUserStatusRecently extends UserStatus
{
    public static final int CLASS_ID = 0xe26f42f1;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString()
    {
        return "userStatusRecently#e26f42f1";
    }
}
