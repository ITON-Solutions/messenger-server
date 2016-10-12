package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLIntVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLIntVector;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLVector;

public class TLPrivacyValueDisallowUsers extends PrivacyRule {
    public static final int CLASS_ID = 0xc7f49b7;

    public TLPrivacyValueDisallowUsers() {
    }

    public TLPrivacyValueDisallowUsers(TLIntVector users) {
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
        return "privacy.disallowUsers#c7f49b7";
    }
}