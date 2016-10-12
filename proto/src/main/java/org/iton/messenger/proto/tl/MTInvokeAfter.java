package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class MTInvokeAfter extends TLObject {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTInvokeAfter.class);

    public static final int CLASS_ID = 0xcb9f372d;

    private long msg_id;

    private TLObject request;

    public MTInvokeAfter(){}

    public MTInvokeAfter(long msg_id, TLObject request) {
        this.msg_id  = msg_id;
        this.request = request;
    }

    public long getMsgId() {
        return msg_id;
    }

    public TLObject getRequest() {
        return request;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(msg_id, stream);
        writeTLObject(request, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.msg_id  = readLong(stream);
        this.request = readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "invokeAfterMsg#cb9f372d";
    }
}
