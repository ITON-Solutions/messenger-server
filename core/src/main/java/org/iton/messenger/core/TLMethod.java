package org.iton.messenger.core;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;

/**
 * Basic object for RPC methods. It contains special methods for deserialize result of RPC method call.
 *
 * @param <T> return type of method
 * @author Korshakov Stepan <me@ex3ndr.com>
 */
public abstract class TLMethod<T extends TLObject> extends TLObject {
    public T deserializeResponse(byte[] data, TLContext context) throws IOException {
        return deserializeResponse(Unpooled.copiedBuffer(data), context);
    }

    public abstract T deserializeResponse(ByteBuf stream, TLContext context) throws IOException;
}
