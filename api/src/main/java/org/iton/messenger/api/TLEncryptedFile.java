package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLEncryptedFile extends EncryptedFile {
    public static final int CLASS_ID = 0x4a70994c;
    ;

    public TLEncryptedFile() {
    }

    public TLEncryptedFile(long id, long access_hash, int size, int dc_id, int key_fingerprint) {
        this.id              = id;
        this.access_hash     = access_hash;
        this.size            = size;
        this.dc_id           = dc_id;
        this.key_fingerprint = key_fingerprint;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
        writeLong(this.access_hash, stream);
        writeInt(this.size, stream);
        writeInt(this.dc_id, stream);
        writeInt(this.key_fingerprint, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id              = readLong(stream);
        this.access_hash     = readLong(stream);
        this.size            = readInt(stream);
        this.dc_id           = readInt(stream);
        this.key_fingerprint = readInt(stream);
    }

    @Override
    public String toString() {
        return "encryptedFile#4a70994c";
    }
}