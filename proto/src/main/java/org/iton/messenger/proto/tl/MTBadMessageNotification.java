package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class MTBadMessageNotification extends MTBadMessage {

    public static final int CLASS_ID = 0xa7eff811;

    public MTBadMessageNotification(long badMsgId, int badMsqSeqno, int errorCode) {
        this.badMsgId = badMsgId;
        this.badMsqSeqno = badMsqSeqno;
        this.errorCode = errorCode;
    }

    public MTBadMessageNotification() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(badMsgId, stream);
        writeInt(badMsqSeqno, stream);
        writeInt(errorCode, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        badMsgId = readLong(stream);
        badMsqSeqno = readInt(stream);
        errorCode = readInt(stream);
    }

    @Override
    public String toString() {
        return "bad_msg_notification#a7eff811";
    }
}
