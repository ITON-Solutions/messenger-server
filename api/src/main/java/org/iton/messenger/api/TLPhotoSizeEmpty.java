package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

public class TLPhotoSizeEmpty extends PhotoSize
{
  public static final int CLASS_ID = 0xe17e23c;

  public TLPhotoSizeEmpty()
  {
  }

  public TLPhotoSizeEmpty(String type)
  {
    this.type = type;
  }

  @Override
  public int getClassId()
  {
    return CLASS_ID;
  }

  @Override
  public void serializeBody(ByteBuf stream) throws IOException
  {
    StreamingUtils.writeTLString(this.type, stream);
  }

  @Override
  public void deserializeBody(ByteBuf stream, TLContext context) throws IOException
  {
    this.type = StreamingUtils.readTLString(stream);
  }

  @Override
  public String toString()
  {
    return "photoSizeEmpty#e17e23c";
  }
}