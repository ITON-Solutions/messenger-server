package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLFutureSalt extends TLObject {

    public static final int CLASS_ID = 0x0949d9dc;

    private int validSince;
    private int validUntil;
    private long salt;

    public TLFutureSalt(int validSince, int validUntil, long salt) {
        this.validSince = validSince;
        this.validUntil = validUntil;
        this.salt = salt;
    }

    public TLFutureSalt() {

    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getValidSince() {
        return validSince;
    }

    public int getValidUntil() {
        return validUntil;
    }

    public long getSalt() {
        return salt;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(validSince, stream);
        writeInt(validUntil, stream);
        writeLong(salt, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        validSince = readInt(stream);
        validUntil = readInt(stream);
        salt = readLong(stream);
    }

    @Override
    public String toString() {
        return "future_salt#0949d9dc";
    }
}
