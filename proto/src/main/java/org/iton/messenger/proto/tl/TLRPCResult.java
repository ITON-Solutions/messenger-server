package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.proto.util.BytesCache;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLRPCResult extends TLObject {

    public static final int CLASS_ID = 0xf35c6d01;

    private long message_id;
    private byte[] content;
    private int length;

    public TLRPCResult(long message_id, byte[] content, int length) {
        this.message_id = message_id;
        this.content    = content;
        this.length    = length;
    }

    public TLRPCResult() {

    }

    public long getMessageId() {
        return message_id;
    }

    public byte[] getContent() {
        return content;
    }

    public int getContentLength() {
        return length;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(message_id, stream);
        writeBytes(content, 0, length, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.message_id = readLong(stream);
        int capacity = stream.capacity();
        content = BytesCache.getInstance().allocate(capacity);
        readBytes(content, 0, capacity, stream);
    }

    @Override
    public String toString() {
        return "rpc_result#f35c6d01";
    }
}
