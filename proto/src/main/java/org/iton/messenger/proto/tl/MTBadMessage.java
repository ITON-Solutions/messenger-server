package org.iton.messenger.proto.tl;

import org.iton.messenger.core.TLObject;


public abstract class MTBadMessage extends TLObject {
    protected long badMsgId;
    protected int badMsqSeqno;
    protected int errorCode;

    public long getBadMsgId() {
        return badMsgId;
    }

    public int getBadMsqSeqno() {
        return badMsqSeqno;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
