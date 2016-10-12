package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLFileLocationUnavailable extends FileLocation {
    public static final int CLASS_ID = 0x7c596b46;

    public TLFileLocationUnavailable() {
    }

    public TLFileLocationUnavailable(long volume_id, int local_id, long secret) {
        this.volume_id = volume_id;
        this.local_id  = local_id;
        this.secret    = secret;
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.volume_id, stream);
        writeInt(this.local_id, stream);
        writeLong(this.secret, stream);
    }

    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.volume_id = readLong(stream);
        this.local_id  = readInt(stream);
        this.secret    = readLong(stream);
    }

    public String toString() {
        return "fileLocationUnavailable#7c596b46";
    }
}
