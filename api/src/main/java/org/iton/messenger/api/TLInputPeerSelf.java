package org.iton.messenger.api;


public class TLInputPeerSelf extends InputPeer {
    public static final int CLASS_ID = 0x7da07ec9;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "input.peerSelf#7da07ec9";
    }
}
