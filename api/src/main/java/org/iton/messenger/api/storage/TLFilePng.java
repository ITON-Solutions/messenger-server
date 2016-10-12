package org.iton.messenger.api.storage;


public class TLFilePng extends FileType {
    public static final int CLASS_ID = 0xa4f63c0;

    public static final String MIME_TYPE = "image/png";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.filePng#a4f63c0";
    }
}
