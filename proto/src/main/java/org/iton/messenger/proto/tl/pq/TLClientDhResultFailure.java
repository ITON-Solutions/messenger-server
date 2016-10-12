package org.iton.messenger.proto.tl.pq;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 03.11.13
 * Time: 7:20
 */
public class TLClientDhResultFailure extends TLClientDhResult {
    public static final int CLASS_ID = 0xa69dae02;

    public TLClientDhResultFailure(byte[] nonce, byte[] serverNonce, byte[] newNonceHash) {
        super(nonce, serverNonce, newNonceHash);
    }

    public TLClientDhResultFailure() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "dh_gen_fail#a69dae02";
    }
}
