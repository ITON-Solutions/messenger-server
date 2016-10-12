package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.updates.Updates;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.api.Message.MESSAGE_FLAG_FWD;
import static org.iton.messenger.api.Message.MESSAGE_FLAG_REPLY;
import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateShortMessage extends Updates {
    public static final int CLASS_ID = 0xed5c2127;

    public TLUpdateShortMessage() {
    }

    public TLUpdateShortMessage(int flags,
                                int id,
                                int user_id,
                                String message,
                                int pts,
                                int pts_count,
                                int date,
                                int fwd_from_id,
                                int fwd_date,
                                int reply_to_msg_id) {

        this.flags           = flags;
        this.id              = id;
        this.user_id         = user_id;
        this.message         = message;
        this.pts             = pts;
        this.pts_count       = pts_count;
        this.date            = date;
        this.fwd_from_id     = fwd_from_id;
        this.fwd_date        = fwd_date;
        this.reply_to_msg_id = reply_to_msg_id;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.flags, stream);
        writeInt(this.id, stream);
        writeInt(this.user_id, stream);
        writeTLString(this.message, stream);
        writeInt(this.pts, stream);
        writeInt(this.pts_count, stream);
        writeInt(this.date, stream);

        if ((flags & MESSAGE_FLAG_FWD) != 0) {
            writeInt(this.fwd_from_id, stream);
            writeInt(this.fwd_date, stream);
        }
        if ((flags & MESSAGE_FLAG_REPLY) != 0) {
            writeInt(this.reply_to_msg_id, stream);
        }
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.flags     = readInt(stream);
        this.id        = readInt(stream);
        this.user_id   = readInt(stream);
        this.message   = readTLString(stream);
        this.pts       = readInt(stream);
        this.pts_count = readInt(stream);
        this.date      = readInt(stream);

        if ((flags & MESSAGE_FLAG_FWD) != 0) {
            this.fwd_from_id = readInt(stream);
            this.fwd_date    = readInt(stream);
        }
        if ((flags & MESSAGE_FLAG_REPLY) != 0) {
            this.reply_to_msg_id = readInt(stream);
        }
    }

    @Override
    public String toString() {
        return "updates.shortMessage#ed5c2127";
    }
}