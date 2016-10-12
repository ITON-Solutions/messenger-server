package org.iton.messenger.api;

public class TLInputDocumentEmpty extends InputDocument
{
  public static final int CLASS_ID = 0x72f0eaae;

  public int getClassId()
  {
    return CLASS_ID;
  }

  public String toString()
  {
    return "input.documentEmpty#72f0eaae";
  }
}
