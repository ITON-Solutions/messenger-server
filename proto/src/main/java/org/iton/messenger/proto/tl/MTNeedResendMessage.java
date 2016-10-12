package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;
import org.iton.messenger.core.TLObject;

import java.io.IOException;
import java.util.Collections;

import static org.iton.messenger.core.utils.StreamingUtils.readTLLongVector;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLVector;


public class MTNeedResendMessage extends TLObject {

    public static final int CLASS_ID = 0x7d861a08;

    private TLLongVector messages;

    public MTNeedResendMessage(TLLongVector messages) {
        this.messages = messages;
    }

    public MTNeedResendMessage() {
        this.messages = new TLLongVector();
    }

    public MTNeedResendMessage(long[] msgIds) {
        this.messages = new TLLongVector();
        for (long id : msgIds) {
            this.messages.add(id);
        }
    }

    public MTNeedResendMessage(Long[] msgIds) {
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
        return "msg_resend_req#7d861a08";
    }
}
