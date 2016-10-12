package org.iton.messenger.api;


public class TLUserProfilePhotoEmpty extends UserProfilePhoto
{
  public static final int CLASS_ID = 0x4f11bae1;

  public TLUserProfilePhotoEmpty(){}

  public int getClassId()
  {
    return CLASS_ID;
  }

  public String toString()
  {
    return "userProfilePhotoEmpty#4f11bae1";
  }
}
