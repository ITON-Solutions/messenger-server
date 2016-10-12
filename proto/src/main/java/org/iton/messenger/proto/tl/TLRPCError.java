package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLRPCError extends RPCError {


    public static final int CLASS_ID = 0x2144ca19;

    public TLRPCError(int error_code, String error_message) {
        this.error_code    = error_code;
        this.error_message = error_message;
    }

    public TLRPCError() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(error_code, stream);
        writeTLString(error_message, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.error_code    = readInt(stream);
        this.error_message = readTLString(stream);
    }

    @Override
    public String toString() {
        return "rpc.error#2144ca19";
    }
}
