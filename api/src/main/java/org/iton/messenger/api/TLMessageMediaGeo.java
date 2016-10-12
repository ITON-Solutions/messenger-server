package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLMessageMediaGeo extends MessageMedia
{
  public static final int CLASS_ID = 0x56e0d474;

  public TLMessageMediaGeo()
  {
  }

  public TLMessageMediaGeo(GeoPoint geo)
  {
    this.geo = geo;
  }

  @Override
  public int getClassId()
  {
    return CLASS_ID;
  }


  public void serializeBody(ByteBuf stream) throws IOException
  {
    writeTLObject(this.geo, stream);
  }

  @Override
  public void deserializeBody(ByteBuf stream, TLContext context)
    throws IOException
  {
    this.geo = ((GeoPoint) readTLObject(stream, context));
  }

  @Override
  public String toString()
  {
    return "message.mediaGeo#56e0d474";
  }
}