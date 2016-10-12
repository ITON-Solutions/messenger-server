package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.InputMedia;
import org.iton.messenger.api.InputPeer;
import org.iton.messenger.api.updates.Updates;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesSendMedia extends TLMethod<Updates> {
    public static final int CLASS_ID = 0x2d7923b1;
    protected int flags;
    protected InputPeer peer;
    protected int reply_to_msg_id;
    protected InputMedia media;
    protected long random_id;

    public TLRequestMessagesSendMedia(){}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesSendMedia(int flags, InputPeer peer, int reply_to_msg_id, InputMedia media, long random_id) {
        this.flags           = flags;
        this.peer            = peer;
        this.reply_to_msg_id = reply_to_msg_id;
        this.media           = media;
        this.random_id       = random_id;
    }

    @Override
    public Updates deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof Updates)
            return (Updates) res;
        throw new IOException("Incorrect response type. Expected Updates, got: " + res.getClass().getCanonicalName());
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public InputPeer getPeer() {
        return peer;
    }

    public void setPeer(InputPeer peer) {
        this.peer = peer;
    }

    public int getReplyToMsgId() {
        return reply_to_msg_id;
    }

    public void setReplyToMsgId(int reply_to_msg_id) {
        this.reply_to_msg_id = reply_to_msg_id;
    }

    public InputMedia getMedia() {
        return media;
    }

    public void setMedia(InputMedia media) {
        this.media = media;
    }

    public long getRandomId() {
        return random_id;
    }

    public void setRandomId(long random_id) {
        this.random_id = random_id;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.flags, stream);
        writeTLObject(this.peer, stream);

        if ((this.flags & 1) != 0) {
            writeInt(this.reply_to_msg_id, stream);
        }
        writeTLObject(this.media, stream);
        writeLong(this.random_id, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.flags = readInt(stream);
        this.peer = (InputPeer) readTLObject(stream, context);

        if ((flags & 1) != 0) {
            this.reply_to_msg_id = readInt(stream);
        }

        this.media = (InputMedia) readTLObject(stream, context);
        this.random_id = readLong(stream);
    }

    @Override
    public String toString() {
        return "messages.sendMedia#2d7923b1";
    }


}