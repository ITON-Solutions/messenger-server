package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRpcAnswerDropped extends RpcDropAnswer {
    public static final int CLASS_ID = 0xa43ad8b7;


    public TLRpcAnswerDropped() {
    }

    public TLRpcAnswerDropped(long msg_id, int seq_no, int bytes) {
        this.msg_id = msg_id;
        this.seq_no = seq_no;
        this.bytes  = bytes;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.msg_id, stream);
        writeInt(this.seq_no, stream);
        writeInt(this.bytes, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.msg_id = readLong(stream);
        this.seq_no = readInt(stream);
        this.bytes  = readInt(stream);
    }

    @Override
    public String toString() {
        return "rpc.answerDropped#a43ad8b7";
    }
}