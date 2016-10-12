package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class MTMessageDetailedInfo extends TLObject {
    public static final int CLASS_ID = 0x276d3ec6;

    private long msgId;
    private long answerMsgId;
    private int bytes;
    private int state;

    public MTMessageDetailedInfo(long msgId, long answerMsgId, int bytes, int state) {
        this.msgId = msgId;
        this.answerMsgId = answerMsgId;
        this.bytes = bytes;
        this.state = state;
    }

    public MTMessageDetailedInfo() {

    }

    public long getMsgId() {
        return msgId;
    }

    public long getAnswerMsgId() {
        return answerMsgId;
    }

    public int getBytes() {
        return bytes;
    }

    public int getState() {
        return state;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(msgId, stream);
        writeLong(answerMsgId, stream);
        writeInt(bytes, stream);
        writeInt(state, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        msgId = readLong(stream);
        answerMsgId = readLong(stream);
        bytes = readInt(stream);
        state = readInt(stream);
    }

    @Override
    public String toString() {
        return "msg_detailed_info#276d3ec6";
    }
}
