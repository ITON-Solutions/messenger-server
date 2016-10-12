package org.iton.messenger.api.storage;


public class TLFileJpeg extends FileType {
    public static final int CLASS_ID = 0x7efe0e;

    public static final String MIME_TYPE = "image/jpeg";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.fileJpeg#7efe0e";
    }
}
