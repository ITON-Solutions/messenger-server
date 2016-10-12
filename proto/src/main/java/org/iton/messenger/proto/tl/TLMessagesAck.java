package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;
import org.iton.messenger.core.TLObject;

import java.io.IOException;
import java.util.Collections;

import static org.iton.messenger.core.utils.StreamingUtils.readTLLongVector;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLVector;

public class TLMessagesAck extends TLObject {

    public static final int CLASS_ID = 0x62d6b459;

    private TLLongVector messages;

    public TLMessagesAck(TLLongVector messages) {
        this.messages = messages;
    }

    public TLMessagesAck() {
        this.messages = new TLLongVector();
    }

    public TLMessagesAck(long[] msgIds) {
        this.messages = new TLLongVector();
        for (long id : msgIds) {
            this.messages.add(id);
        }
    }

    public TLMessagesAck(Long[] msgIds) {
        this.messages = new TLLongVector();
        Collections.addAll(this.messages, msgIds);
    }

    public TLLongVector getMessages() {
        return messages;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(messages, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        messages = readTLLongVector(stream, context);
    }

    @Override
    public String toString() {
        return "msgs_ack#62d6b459";
    }
}
