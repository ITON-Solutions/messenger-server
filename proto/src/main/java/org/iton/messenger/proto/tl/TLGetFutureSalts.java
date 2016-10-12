package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;


public class TLGetFutureSalts extends TLObject {

    public static final int CLASS_ID = 0xb921bd04;

    private int num;

    public TLGetFutureSalts(int num) {
        this.num = num;
    }

    public TLGetFutureSalts() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(num, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        num = readInt(stream);
    }

    @Override
    public String toString() {
        return "get_future_salts#b921bd04";
    }
}
