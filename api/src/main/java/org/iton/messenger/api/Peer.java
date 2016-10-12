package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class Peer extends TLObject
{
    protected int user_id;
    protected int chat_id;

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getChatId() {
        return chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }
}
