package org.iton.messenger.core;

import java.util.Arrays;

/**
 * Created by ex3ndr on 10.02.14.
 */
public class TLBytes {
    private byte[] data;
    private int offset;
    private int len;

    public TLBytes(byte[] data) {
        this.data = data;
        this.offset = 0;
        this.len = data.length;
    }

    public TLBytes(byte[] data, int offset, int len) {
        this.data = data;
        this.offset = offset;
        this.len = len;
    }

    public byte[] getData() {
        return data;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return len;
    }

    public byte[] cleanData() {
        if (offset == 0 && len == data.length) {
            return data;
        }
        return Arrays.copyOfRange(data, offset, len);
    }
}
