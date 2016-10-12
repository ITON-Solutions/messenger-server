package org.iton.messenger.api.storage;

public class TLFileWebp extends FileType {
    public static final int CLASS_ID = 0x1081464c;

    public static final String MIME_TYPE = "image/webp";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.fileWebp#1081464c";
    }
}
