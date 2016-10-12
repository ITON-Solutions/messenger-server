package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.RpcDropAnswer;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestRpcDropAnswer extends TLMethod<RpcDropAnswer> {
    public static final int CLASS_ID = 0x58e4a740;

    protected long req_msg_id;

    public TLRequestRpcDropAnswer() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestRpcDropAnswer(long req_msg_id) {
        this.req_msg_id = req_msg_id;
    }

    @Override
    public RpcDropAnswer deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof RpcDropAnswer))
            return (RpcDropAnswer) res;
        throw new IOException("Incorrect response type. Expected DropAnswer, got: " + res.getClass().getCanonicalName());
    }

    public long getReqMsgId() {
        return req_msg_id;
    }

    public void setReqMsgId(long req_msg_id) {
        this.req_msg_id = req_msg_id;
    }

    public int getLayer() {
        return 0;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.req_msg_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.req_msg_id = readLong(stream);
    }

    @Override
    public String toString() {
        return "rpc.dropAnswer#58e4a740";
    }
}