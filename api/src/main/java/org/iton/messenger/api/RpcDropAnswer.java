package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class RpcDropAnswer extends TLObject {
    protected long msg_id;
    protected int seq_no;
    protected int bytes;


    public long getMsgId() {
        return msg_id;
    }

    public void setMsgId(long msg_id) {
        this.msg_id = msg_id;
    }

    public int getSeqNo() {
        return seq_no;
    }

    public void setSeqNo(int seq_no) {
        this.seq_no = seq_no;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
