package org.iton.messenger.api.storage;


public class TLFileGif extends FileType {
    public static final int CLASS_ID = 0xcae1aadf;

    public static final String MIME_TYPE = "image/gif";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.fileGif#cae1aadf";
    }
}
