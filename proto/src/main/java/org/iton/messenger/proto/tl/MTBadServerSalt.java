package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class MTBadServerSalt extends MTBadMessage {

    public static final int CLASS_ID = 0xedab447b;

    private long newSalt;

    public MTBadServerSalt(long messageId, int seqNo, int errorNo, long newSalt) {
        this.badMsgId = messageId;
        this.badMsqSeqno = seqNo;
        this.errorCode = errorNo;
        this.newSalt = newSalt;
    }

    public MTBadServerSalt() {

    }

    public long getNewSalt() {
        return newSalt;
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
        writeLong(newSalt, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        badMsgId = readLong(stream);
        badMsqSeqno = readInt(stream);
        errorCode = readInt(stream);
        newSalt = readLong(stream);
    }

    @Override
    public String toString() {
        return "bad_server_salt#edab447b";
    }
}
