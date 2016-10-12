package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLIntVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLPrivacyValueAllowUsers extends PrivacyRule {
    public static final int CLASS_ID = 0x4d5bbe0c;

    public TLPrivacyValueAllowUsers() {
    }

    public TLPrivacyValueAllowUsers(TLIntVector users) {
        this.users = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.users = readTLIntVector(stream, context);
    }

    @Override
    public String toString() {
        return "privacy.allowUsers#4d5bbe0c";
    }
}