package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUserStatusOnline extends UserStatus
{
    public static final int CLASS_ID = 0xedb93949;

    public TLUserStatusOnline() {
    }

    public TLUserStatusOnline(int expires) {
        this.expires = expires;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException
    {
        writeInt(this.expires, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException
    {
        this.expires = readInt(stream);
    }

    @Override
    public String toString()
    {
        return "userStatusOnline#edb93949";
    }
}
