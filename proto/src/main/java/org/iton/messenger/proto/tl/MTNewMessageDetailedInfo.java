package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class MTNewMessageDetailedInfo extends TLObject {

    public static final int CLASS_ID = 0x809db6df;

    private long answerMsgId;
    private int bytes;
    private int status;

    public MTNewMessageDetailedInfo(long answerMsgId, int bytes, int status) {
        this.answerMsgId = answerMsgId;
        this.bytes = bytes;
        this.status = status;
    }

    public MTNewMessageDetailedInfo() {

    }

    public long getAnswerMsgId() {
        return answerMsgId;
    }

    public int getBytes() {
        return bytes;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(answerMsgId, stream);
        writeInt(bytes, stream);
        writeInt(status, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        answerMsgId = readLong(stream);
        bytes = readInt(stream);
        status = readInt(stream);
    }

    @Override
    public String toString() {
        return "msg_new_detailed_info#809db6df";
    }
}
