package org.iton.messenger.core;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.utils.StreamingUtils;

import java.io.IOException;
import static org.iton.messenger.core.utils.StreamingUtils.readTLBytes;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLBytes;


public class TLGzipObject extends TLObject {
    public static final int CLASS_ID = 0x3072cfa1;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLGzipObject(byte[] packedData) {
        this.packedData = packedData;
    }

    public TLGzipObject() {

    }

    private byte[] packedData;

    public byte[] getPackedData() {
        return packedData;
    }

    public void setPackedData(byte[] packedData) {
        this.packedData = packedData;
    }

    @Override
    public void serializeBody(ByteBuf buf) throws IOException {
        StreamingUtils.writeTLBytes(packedData, buf);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        packedData = StreamingUtils.readTLBytes(stream);
    }

    @Override
    public String toString() {
        return "gzip_packed#3072cfa1";
    }
}
