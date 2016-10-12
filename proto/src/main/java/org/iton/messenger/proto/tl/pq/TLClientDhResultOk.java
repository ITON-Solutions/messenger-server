package org.iton.messenger.proto.tl.pq;


public class TLClientDhResultOk extends TLClientDhResult
{
    public static final int CLASS_ID = 0x3bcbf734;

    public TLClientDhResultOk(byte[] nonce, byte[] serverNonce, byte[] newNonceHash) {
        super(nonce, serverNonce, newNonceHash);
    }

    public TLClientDhResultOk() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "dh_gen_ok#3bcbf734";
    }
}
