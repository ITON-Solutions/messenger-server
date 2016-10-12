package org.iton.messenger.core;

/**
 * TL Vector of integers. @see org.telegram.server.tl.TLVector
 *
 * @author Korshakov Stepan <me@ex3ndr.com>
 */
public class TLIntVector extends TLVector<Integer> {
    public TLIntVector() {
        setDestClass(Integer.class);
    }

    @Override
    public String toString() {
        return "vector<int>#1cb5c415";
    }

    public int[] toIntArray() {
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = get(i);
        }
        return res;
    }
}
