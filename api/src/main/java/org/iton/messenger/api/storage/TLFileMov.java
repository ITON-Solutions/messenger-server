package org.iton.messenger.api.storage;


public class TLFileMov extends FileType {
    public static final int CLASS_ID = 0x4b09ebbc;

    public static final String MIME_TYPE = "video/quicktime";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.fileMov#4b09ebbc";
    }
}
