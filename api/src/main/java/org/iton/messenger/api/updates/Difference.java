package org.iton.messenger.api.updates;

import org.iton.messenger.api.*;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Difference extends TLObject
{
    protected int date;
    protected int seq;
    protected TLVector<Message> new_messages;
    protected TLVector<EncryptedMessage> new_encrypted_messages;
    protected TLVector<Update> other_updates;
    protected TLVector<Chat> chats;
    protected TLVector<User> users;
    protected TLState intermediate_state;
    protected TLState state;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public TLVector<Message> getNewMessages() {
        return new_messages;
    }

    public void setNewMessages(TLVector<Message> new_messages) {
        this.new_messages = new_messages;
    }

    public TLVector<EncryptedMessage> getNewEncryptedMessages() {
        return new_encrypted_messages;
    }

    public void setNewEncryptedMessages(TLVector<EncryptedMessage> new_encrypted_messages) {
        this.new_encrypted_messages = new_encrypted_messages;
    }

    public TLVector<Update> getOtherUpdates() {
        return other_updates;
    }

    public void setOtherUpdates(TLVector<Update> other_updates) {
        this.other_updates = other_updates;
    }

    public TLVector<Chat> getChats() {
        return chats;
    }

    public void setChats(TLVector<Chat> chats) {
        this.chats = chats;
    }

    public TLVector<User> getUsers() {
        return users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    public TLState getIntermediateState() {
        return intermediate_state;
    }

    public void setIntermediateState(TLState intermediate_state) {
        this.intermediate_state = intermediate_state;
    }

    public TLState getState() {
        return state;
    }

    public void setState(TLState state) {
        this.state = state;
    }
}