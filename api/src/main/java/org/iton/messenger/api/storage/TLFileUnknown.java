package org.iton.messenger.api.storage;


public class TLFileUnknown extends FileType {
    public static final int CLASS_ID = 0xaa963b05;

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.fileUnknown#aa963b05";
    }
}
