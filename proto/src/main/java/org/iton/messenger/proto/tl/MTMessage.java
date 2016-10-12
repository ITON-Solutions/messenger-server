package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.proto.util.BytesCache;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class MTMessage extends TLObject {
    private long messageId;
    private int seqNo;
    private byte[] content;
    private int contentLen;

    public MTMessage(long messageId, int seqNo, byte[] content) {
        this(messageId, seqNo, content, content.length);
    }

    public MTMessage(long messageId, int seqNo, byte[] content, int contentLen) {
        this.messageId  = messageId;
        this.seqNo      = seqNo;
        this.content    = content;
        this.contentLen = contentLen;
    }

    public MTMessage() {

    }

    @Override
    public int getClassId() {
        return 0;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getContentLen() {
        return contentLen;
    }

    public void setContentLen(int contentLen) {
        this.contentLen = contentLen;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(messageId, stream);
        writeInt(seqNo, stream);
        writeInt(content.length, stream);
        writeBytes(content, 0, contentLen, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        messageId = readLong(stream);
        seqNo     = readInt(stream);
        int size  = readInt(stream);
        content   = BytesCache.getInstance().allocate(size);
        readBytes(content, 0, size, stream);
    }

    @Override
    public String toString() {
        return "message";
    }
}
