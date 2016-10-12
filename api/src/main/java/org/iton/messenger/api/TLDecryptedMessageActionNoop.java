package org.iton.messenger.api;

public class TLDecryptedMessageActionNoop extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xa82fdd63;

    public TLDecryptedMessageActionNoop() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "decrypted.message.action.Noop#a82fdd63";
    }
}