package org.iton.messenger.api;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;

public class TLDecryptedMessageActionFlushHistory extends DecryptedMessageAction {
    public static final int CLASS_ID = 0x6719e45c;

    public TLDecryptedMessageActionFlushHistory() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public String toString() {
        return "decrypted.message.action.FlushHistory#6719e45c";
    }
}