package org.iton.messenger.api;


public class TLInputPeerEmpty extends InputPeer {
    public static final int CLASS_ID = 0x7f3b18ea;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "input.peerEmpty#7f3b18ea";
    }
}
