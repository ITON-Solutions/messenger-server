package org.iton.messenger.api.storage;


public class TLFileMp3 extends FileType {
    public static final int CLASS_ID = 0x528a0677;

    public static final String MIME_TYPE = "audio/mpeg";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.fileMp3#528a0677";
    }
}
