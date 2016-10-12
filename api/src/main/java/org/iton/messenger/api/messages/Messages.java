package org.iton.messenger.api.messages;

import org.iton.messenger.api.Chat;
import org.iton.messenger.api.Message;
import org.iton.messenger.api.User;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Messages extends TLObject
{
  protected TLVector<Message> messages;
  protected TLVector<Chat> chats;
  protected TLVector<User> users;

  protected int count;

  public TLVector<Message> getMessages()
  {
    return this.messages;
  }

  public void setMessages(TLVector<Message> messages)
  {
    this.messages = messages;
  }

  public TLVector<Chat> getChats()
  {
    return this.chats;
  }

  public void setChats(TLVector<Chat> chats)
  {
    this.chats = chats;
  }

  public TLVector<User> getUsers()
  {
    return this.users;
  }

  public void setUsers(TLVector<User> users)
  {
    this.users = users;
  }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}