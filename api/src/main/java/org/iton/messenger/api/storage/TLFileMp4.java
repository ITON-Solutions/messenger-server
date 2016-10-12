package org.iton.messenger.api.storage;


public class TLFileMp4 extends FileType {
    public static final int CLASS_ID = 0xb3cea0e4;

    public static final String MIME_TYPE = "video/mp4";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.fileMp4#b3cea0e4";
    }
}
