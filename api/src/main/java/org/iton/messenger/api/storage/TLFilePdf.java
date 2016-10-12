package org.iton.messenger.api.storage;


public class TLFilePdf extends FileType {
    public static final int CLASS_ID = 0xae1e508d;

    public static final String MIME_TYPE = "application/pdf";

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "storage.filePdf#ae1e508d";
    }
}
