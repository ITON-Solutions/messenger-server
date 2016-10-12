package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDecryptedMessageActionCommitKey extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xec2e0b9b;

    public TLDecryptedMessageActionCommitKey() {
    }

    public TLDecryptedMessageActionCommitKey(long exchange_id, long key_fingerprint) {
        this.exchange_id     = exchange_id;
        this.key_fingerprint = key_fingerprint;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.exchange_id, stream);
        writeLong(this.key_fingerprint, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.exchange_id     = readLong(stream);
        this.key_fingerprint = readLong(stream);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.CommitKey#ec2e0b9b";
    }
}