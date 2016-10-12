package org.iton.messenger.api;

public class TLInputMessagesFilterEmpty extends MessagesFilter
{
  public static final int CLASS_ID = 0x57e2f66c;

  @Override
  public int getClassId()
  {
    return CLASS_ID;
  }

  @Override
  public String toString()
  {
    return "input.messagesFilterEmpty#57e2f66c";
  }
}