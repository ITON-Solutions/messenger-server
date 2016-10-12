package org.iton.messenger.api;


import org.iton.messenger.api.updates.Updates;

public class TLUpdatesTooLong extends Updates {
    public static final int CLASS_ID = 0xe317af7e;

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "updates.tooLong#e317af7e";
    }
}
