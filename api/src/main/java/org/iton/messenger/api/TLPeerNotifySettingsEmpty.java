package org.iton.messenger.api;


public class TLPeerNotifySettingsEmpty extends PeerNotifySettings
{
  public static final int CLASS_ID = 0x70a68512;

  @Override
  public int getClassId()
  {
    return CLASS_ID;
  }

  public String toString()
  {
    return "peerNotifySettingsEmpty#70a68512";
  }
}
