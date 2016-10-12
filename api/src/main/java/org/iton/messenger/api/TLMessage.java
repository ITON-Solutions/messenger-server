package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLMessage extends Message {
    public static final int CLASS_ID = 0xa7ab1991;

    public TLMessage() {
    }

    public TLMessage(int flags,
                     int id,
                     int from_id,
                     Peer to_id,
                     int fwd_from_id,
                     int fwd_date,
                     int reply_to_msg_id,
                     int date,
                     String message,
                     MessageMedia media,
                     String attach_path,
                     int fwd_msg_id) {

        this.flags           = flags;
        this.id              = id;
        this.from_id         = from_id;
        this.to_id           = to_id;
        this.fwd_from_id     = fwd_from_id;
        this.fwd_date        = fwd_date;
        this.reply_to_msg_id = reply_to_msg_id;
        this.date            = date;
        this.message         = message;
        this.media           = media;
        this.attach_path     = attach_path;
        this.fwd_msg_id      = fwd_msg_id;

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.flags, stream);
        writeInt(this.id, stream);
        writeInt(this.from_id, stream);
        writeTLObject(this.to_id, stream);

        if ((flags & MESSAGE_FLAG_FWD) != 0) {
            writeInt(this.fwd_from_id, stream);
            writeInt(this.fwd_date, stream);
        }
        if ((flags & MESSAGE_FLAG_REPLY) != 0) {
            writeInt(this.reply_to_msg_id, stream);
        }

        writeInt(this.date, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);

        if (id < 0 || (media != null && !(media instanceof TLMessageMediaEmpty) && message != null && message.length() != 0 && message.startsWith("-1"))) {
            writeTLString(this.attach_path, stream);
        }

        if ((flags & MESSAGE_FLAG_FWD) != 0 && id < 0) {
            writeInt(this.fwd_msg_id, stream);
        }
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {

        this.flags   = readInt(stream);
        this.id      = readInt(stream);
        this.from_id = readInt(stream);
        this.to_id   = (Peer) readTLObject(stream, context);

        if ((flags & MESSAGE_FLAG_FWD) != 0) {
            this.fwd_from_id = readInt(stream);
            this.fwd_date    = readInt(stream);
        }
        if ((flags & MESSAGE_FLAG_REPLY) != 0) {
            reply_to_msg_id = readInt(stream);
        }

        this.date    = readInt(stream);
        this.message = readTLString(stream);
        this.media   = (MessageMedia) readTLObject(stream, context);

        if (id < 0 || (media != null && !(media instanceof TLMessageMediaEmpty) && message != null && message.length() != 0 && message.startsWith("-1"))) {
            this.attach_path = readTLString(stream);
        }

        if (id < 0 && message.length() > 6 && media instanceof TLMessageMediaVideo) {
            this.videoEditedInfo = new VideoEditedInfo();
            this.videoEditedInfo.parseString(message);
        }
        if ((flags & MESSAGE_FLAG_FWD) != 0 && id < 0) {
            this.fwd_msg_id = readInt(stream);
        }
    }

    @Override
    public String toString() {
        return "message#a7ab1991";
    }
}