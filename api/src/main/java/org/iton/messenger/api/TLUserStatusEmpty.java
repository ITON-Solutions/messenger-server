package org.iton.messenger.api;

public class TLUserStatusEmpty extends UserStatus
{
    public static final int CLASS_ID = 0x9d05049;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String toString()
    {
        return "userStatusEmpty#9d05049";
    }
}
