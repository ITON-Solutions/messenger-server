package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class PhotoSize extends TLObject
{
  protected String type;
  protected FileLocation location;
  protected int width;
  protected int height;
  protected int size;
  protected byte[] data;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FileLocation getLocation() {
    return location;
  }

  public void setLocation(FileLocation location) {
    this.location = location;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}
