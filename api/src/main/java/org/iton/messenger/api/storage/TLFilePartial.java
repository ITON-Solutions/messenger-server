package org.iton.messenger.api.storage;


public class TLFilePartial extends FileType {
    public static final int CLASS_ID = 0x40bc6f52;

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.filePartial#40bc6f52";
    }
}
