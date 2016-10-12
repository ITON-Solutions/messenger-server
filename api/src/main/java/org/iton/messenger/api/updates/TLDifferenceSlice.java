package org.iton.messenger.api.updates;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.*;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDifferenceSlice extends Difference {
    public static final int CLASS_ID = 0xa8fb1981;

    public TLDifferenceSlice() {
    }

    public TLDifferenceSlice(TLVector<Message> new_messages,
                             TLVector<EncryptedMessage> new_encrypted_messages,
                             TLVector<Update> other_updates,
                             TLVector<Chat> chats,
                             TLVector<User> users,
                             TLState intermediate_state) {

        this.new_messages           = new_messages;
        this.new_encrypted_messages = new_encrypted_messages;
        this.other_updates          = other_updates;
        this.chats                  = chats;
        this.users                  = users;
        this.intermediate_state     = intermediate_state;
    }
   @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.new_messages, stream);
        writeTLVector(this.new_encrypted_messages, stream);
        writeTLVector(this.other_updates, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeTLObject(this.intermediate_state, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.new_messages           = readTLVector(stream, context);
        this.new_encrypted_messages = readTLVector(stream, context);
        this.other_updates          = readTLVector(stream, context);
        this.chats                  = readTLVector(stream, context);
        this.users                  = readTLVector(stream, context);
        this.intermediate_state     = (TLState) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "updates.differenceSlice#a8fb1981";
    }
}