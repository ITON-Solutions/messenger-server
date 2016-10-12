package org.iton.messenger.api.messages;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.Chat;
import org.iton.messenger.api.Message;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLMessages extends Messages {
    public static final int CLASS_ID = 0x8c718e87;

    public TLMessages() {
    }

    public TLMessages(TLVector<Message> messages, TLVector<Chat> chats, TLVector<User> users) {
        this.messages = messages;
        this.chats    = chats;
        this.users    = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.messages, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.messages = readTLVector(stream, context);
        this.chats    = readTLVector(stream, context);
        this.users    = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.messages#8c718e87";
    }
}