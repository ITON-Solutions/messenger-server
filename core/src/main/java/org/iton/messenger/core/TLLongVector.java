package org.iton.messenger.core;

/**
 * TL Vector of longs. @see org.telegram.server.tl.TLVector
 *
 * @author Korshakov Stepan <me@ex3ndr.com>
 */
public class TLLongVector extends TLVector<Long> {
    public TLLongVector() {
        setDestClass(Long.class);
    }

    @Override
    public String toString() {
        return "vector<long>#1cb5c415";
    }
}
