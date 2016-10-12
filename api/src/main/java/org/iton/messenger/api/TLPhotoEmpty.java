package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

public class TLPhotoEmpty extends Photo
{
  public static final int CLASS_ID = 0x2331b22d;

  public TLPhotoEmpty()
  {
  }

  public TLPhotoEmpty(long id)
  {
    this.id = id;
  }

  @Override
  public int getClassId()
  {
    return CLASS_ID;
  }

  @Override
  public void serializeBody(ByteBuf stream) throws IOException
  {
    StreamingUtils.writeLong(this.id, stream);
  }

  @Override
  public void deserializeBody(ByteBuf stream, TLContext context) throws IOException
  {
    this.id = StreamingUtils.readLong(stream);
  }

  @Override
  public String toString()
  {
    return "photoEmpty#2331b22d";
  }
}