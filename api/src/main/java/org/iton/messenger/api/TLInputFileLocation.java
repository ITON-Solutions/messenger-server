package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLInputFileLocation extends InputFileLocation {
    public static final int CLASS_ID = 0x14637196;

    public TLInputFileLocation() {
    }

    public TLInputFileLocation(long volume_id, int local_id, long secret) {
        this.volume_id = volume_id;
        this.local_id  = local_id;
        this.secret    = secret;
    }

    @Override
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
        return "input.fileLocation#14637196";
    }
}
