package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLFileEncryptedLocation extends FileLocation
{
  public static final int CLASS_ID = 0x55555554;

  public TLFileEncryptedLocation()
  {
  }

  public TLFileEncryptedLocation(int dc_id, long volume_id, int local_id, long secret)
  {
    this.dc_id     = dc_id;
    this.volume_id = volume_id;
    this.local_id  = local_id;
    this.secret    = secret;
  }

  public int getClassId()
  {
    return CLASS_ID;
  }

  public void serializeBody(ByteBuf stream) throws IOException
  {
    writeInt(this.dc_id, stream);
    writeLong(this.volume_id, stream);
    writeInt(this.local_id, stream);
    writeLong(this.secret, stream);
    writeTLBytes(this.key, stream);
    writeTLBytes(this.iv, stream);
  }

  public void deserializeBody(ByteBuf stream, TLContext context) throws IOException
  {
    this.dc_id     = readInt(stream);
    this.volume_id = readLong(stream);
    this.local_id  = readInt(stream);
    this.secret    = readLong(stream);
    this.key       = readTLBytes(stream);
    this.iv        = readTLBytes(stream);
  }

  public String toString()
  {
    return "fileEncryptedLocation#55555554";
  }
}
