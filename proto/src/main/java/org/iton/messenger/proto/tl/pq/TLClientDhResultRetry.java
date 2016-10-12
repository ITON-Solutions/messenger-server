package org.iton.messenger.proto.tl.pq;


public class TLClientDhResultRetry extends TLClientDhResult {
    public static final int CLASS_ID = 0x46dc1fb9;

    public TLClientDhResultRetry(byte[] nonce, byte[] serverNonce, byte[] newNonceHash) {
        super(nonce, serverNonce, newNonceHash);
    }

    public TLClientDhResultRetry() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "dh_gen_retry#46dc1fb9";
    }
}
