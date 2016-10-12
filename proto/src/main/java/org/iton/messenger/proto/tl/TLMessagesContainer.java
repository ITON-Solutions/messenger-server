package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;


public class TLMessagesContainer extends TLObject {

    public static final int CLASS_ID = 0x73f1f8dc;

    private TreeSet<MTMessage> messages = new TreeSet<MTMessage>(new Comparator<MTMessage>() {
        @Override
        public int compare(MTMessage mtMessage, MTMessage mtMessage2) {
            return (int) Math.signum(mtMessage.getMessageId() - mtMessage2.getMessageId());
        }
    });

    public TLMessagesContainer(MTMessage[] messages) {
        Collections.addAll(this.messages, messages);
    }

    public TLMessagesContainer() {

    }

    public TreeSet<MTMessage> getMessages() {
        return messages;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(messages.size(), stream);
        for (MTMessage message : messages) {
            message.serializeBody(stream);
        }
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        int size = readInt(stream);
        messages.clear();
        for (int i = 0; i < size; i++) {
            MTMessage message = new MTMessage();
            message.deserializeBody(stream, context);
            messages.add(message);
        }
    }

    @Override
    public String toString() {
        return "msg_container#73f1f8dc";
    }
}
