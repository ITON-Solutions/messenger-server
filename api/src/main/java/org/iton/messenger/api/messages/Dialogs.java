package org.iton.messenger.api.messages;

import org.iton.messenger.api.Chat;
import org.iton.messenger.api.Message;
import org.iton.messenger.api.TLDialog;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Dialogs extends TLObject {
    protected TLVector<TLDialog> dialogs;
    protected TLVector<Message> messages;
    protected TLVector<Chat> chats;
    protected TLVector<User> users;
    protected int count;

    public TLVector<TLDialog> getDialogs() {
        return this.dialogs;
    }

    public void setDialogs(TLVector<TLDialog> dialogs) {
        this.dialogs = dialogs;
    }

    public TLVector<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(TLVector<Message> messages) {
        this.messages = messages;
    }

    public TLVector<Chat> getChats() {
        return this.chats;
    }

    public void setChats(TLVector<Chat> chats) {
        this.chats = chats;
    }

    public TLVector<User> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}