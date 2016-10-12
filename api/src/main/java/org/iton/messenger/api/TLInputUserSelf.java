package org.iton.messenger.api;


public class TLInputUserSelf extends InputUser {
    public static final int CLASS_ID = 0xf7c1b13f;

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "input.userSelf#f7c1b13f";
    }
}
