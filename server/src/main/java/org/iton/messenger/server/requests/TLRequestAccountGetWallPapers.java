package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.WallPaper;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLVector;

public class TLRequestAccountGetWallPapers extends TLMethod<TLVector<WallPaper>> {
    public static final int CLASS_ID = 0xc04cfac2;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLVector<WallPaper> deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "account.getWallPapers#c04cfac2";
    }
}

