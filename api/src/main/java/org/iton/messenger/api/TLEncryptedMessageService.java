package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLBytes;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLEncryptedMessageService extends EncryptedMessage {
    public static final int CLASS_ID = 0x23734b06;

    public TLEncryptedMessageService() {
    }

    public TLEncryptedMessageService(long random_id, int chat_id, int date, TLBytes bytes) {
        this.random_id = random_id;
        this.chat_id   = chat_id;
        this.date      = date;
        this.bytes     = bytes;
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream)  throws IOException {
        writeLong(this.random_id, stream);
        writeInt(this.chat_id, stream);
        writeInt(this.date, stream);
        writeTLBytes(this.bytes, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.random_id = readLong(stream);
        this.chat_id   = readInt(stream);
        this.date      = readInt(stream);
        this.bytes     = readTLBytes(stream, context);
    }

    public String toString() {
        return "encryptedMessageService#23734b06";
    }
}
