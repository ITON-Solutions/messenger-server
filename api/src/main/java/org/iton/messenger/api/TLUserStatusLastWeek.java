package org.iton.messenger.api;

public class TLUserStatusLastWeek extends UserStatus
{
    public static final int CLASS_ID = 0x7bf09fc;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String toString()
    {
        return "userStatusLastWeek#7bf09fc";
    }
}
