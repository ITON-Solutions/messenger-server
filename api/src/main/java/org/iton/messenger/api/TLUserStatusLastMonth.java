package org.iton.messenger.api;

public class TLUserStatusLastMonth extends UserStatus
{
    public static final int CLASS_ID = 0x77ebc742;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String toString()
    {
        return "userStatusLastMonth#77ebc742";
    }
}
