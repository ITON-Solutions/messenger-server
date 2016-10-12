package org.iton.messenger.api.messages;

import io.netty.buffer.ByteBuf;

import org.iton.messenger.api.Chat;
import org.iton.messenger.api.TLChatFull;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLMessagesChatFull extends TLObject {
    public static final int CLASS_ID = 0xe5d7d19c;

    protected TLChatFull full_chat;
    protected TLVector<Chat> chats;
    protected TLVector<User> users;

    public TLMessagesChatFull() {
    }

    public TLMessagesChatFull(TLChatFull full_chat, TLVector<Chat> chats, TLVector<User> users) {
        this.full_chat = full_chat;
        this.chats     = chats;
        this.users     = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLChatFull getFullChat() {
        return this.full_chat;
    }

    public void setFullChat(TLChatFull full_chat) {
        this.full_chat = full_chat;
    }

    public TLVector<Chat> getChats() {
        return this.chats;
    }

    public void setChats(TLVector<Chat> value) {
        this.chats = value;
    }

    public TLVector<User> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<User> value) {
        this.users = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.full_chat, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.full_chat = (TLChatFull) readTLObject(stream, context);
        this.chats     = readTLVector(stream, context);
        this.users     = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.chatFull#e5d7d19c";
    }
}