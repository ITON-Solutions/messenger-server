package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateDcOptions extends Update {
    public static final int CLASS_ID = 0x8e5e9873;

    public TLUpdateDcOptions() {
    }

    public TLUpdateDcOptions(TLVector<TLDcOption> dc_options) {
        this.dc_options = dc_options;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLVector(this.dc_options, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.dc_options = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "update.dcOptions#8e5e9873";
    }
}