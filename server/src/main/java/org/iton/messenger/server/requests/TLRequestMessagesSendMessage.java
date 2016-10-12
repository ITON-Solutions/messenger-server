package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputPeer;
import org.iton.messenger.api.messages.SentMessage;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesSendMessage extends TLMethod<SentMessage> {
    public static final int CLASS_ID = 0x9add8f26;

    protected int flags;
    protected InputPeer peer;
    protected int reply_to_msg_id;
    protected String message;
    protected long random_id;


    public TLRequestMessagesSendMessage(){}

     @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesSendMessage(int flags, InputPeer peer, int reply_to_msg_id, String message, long random_id) {
        this.flags           = flags;
        this.peer            = peer;
        this.reply_to_msg_id = reply_to_msg_id;
        this.message         = message;
        this.random_id       = random_id;
    }

    @Override
    public SentMessage deserializeResponse(ByteBuf stream, TLContext context)  throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof SentMessage))
            return (SentMessage) res;
        throw new IOException("Incorrect response type. Expected SentMessage, got: " + res.getClass().getCanonicalName());
    }

    public InputPeer getPeer() {
        return this.peer;
    }

    public void setPeer(InputPeer value) {
        this.peer = value;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public long getRandomId() {
        return this.random_id;
    }

    public void setRandomId(long random_id) {
        this.random_id = random_id;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getReplyToMsgId() {
        return reply_to_msg_id;
    }

    public void setReplyToMsgId(int reply_to_msg_id) {
        this.reply_to_msg_id = reply_to_msg_id;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.flags, stream);
        writeTLObject(this.peer, stream);

        if ((flags & 1) != 0) {
            writeInt(this.reply_to_msg_id, stream);
        }

        writeTLString(this.message, stream);
        writeLong(this.random_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.flags = readInt(stream);
        this.peer  = (InputPeer) readTLObject(stream, context);

        if ((flags & 1) != 0) {
            this.reply_to_msg_id = readInt(stream);
        }

        this.message   = readTLString(stream);
        this.random_id = readLong(stream);
    }

    @Override
    public String toString() {
        return "messages.sendMessage#9add8f26";
    }


}