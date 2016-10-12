package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLRPCRequestError extends RPCError {


    public static final int CLASS_ID = 0x7ae432f5;

    public TLRPCRequestError(long query_id, int error_code, String error_message) {
        this.query_id      = query_id;
        this.error_code    = error_code;
        this.error_message = error_message;
    }

    public TLRPCRequestError() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.query_id, stream);
        writeInt(this.error_code, stream);
        writeTLString(this.error_message, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.query_id      = readLong(stream);
        this.error_code    = readInt(stream);
        this.error_message = readTLString(stream);
    }

    @Override
    public String toString() {
        return "rpc.requestError#0x7ae432f5";
    }
}
