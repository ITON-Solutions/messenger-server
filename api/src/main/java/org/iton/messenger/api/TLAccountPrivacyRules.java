package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLAccountPrivacyRules extends TLObject {
    public static final int CLASS_ID = 0x554abb6f;

    protected TLVector<PrivacyRule> rules = null;
    protected TLVector<User> users        = null;

    public TLAccountPrivacyRules() {
    }

    public TLAccountPrivacyRules(TLVector<PrivacyRule> rules, TLVector<User> users) {
        this.rules = rules;
        this.users = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.rules, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.rules = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }


    public TLVector<PrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<PrivacyRule> rules) {
        this.rules = rules;
    }

    public TLVector<User> getUsers() {
        return users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "account.privacyRules#554abb6f";
    }

}