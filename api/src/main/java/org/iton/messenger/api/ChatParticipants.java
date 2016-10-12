package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class ChatParticipants extends TLObject
{
  protected int chat_id;
  protected int admin_id;
  protected TLVector<TLChatParticipant> participants = new TLVector<>();
  protected int version;

  public int getChatId() {
    return chat_id;
  }

  public void setChat_Id(int chat_id) {
    this.chat_id = chat_id;
  }

  public int getAdminId() {
    return admin_id;
  }

  public void setAdminId(int admin_id) {
    this.admin_id = admin_id;
  }

  public TLVector<TLChatParticipant> getParticipants() {
    return participants;
  }

  public void setParticipants(TLVector<TLChatParticipant> participants) {
    this.participants = participants;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }
}
