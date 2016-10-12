package org.iton.messenger.server.proto;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.server.proto.MTRequestDecoder.State;

import java.util.List;


/**
 * Created by ITON on 9/1/14.
 */
public class MTRequestDecoder extends ReplayingDecoder<State> {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTRequestDecoder.class);

    private int length;
    private int mask;

    public MTRequestDecoder() {
        super(State.READ_LENGTH);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        switch (state()) {
            case READ_LENGTH: {
                in.markReaderIndex();
                mask = in.readByte();
                if (mask != 0x7f) {
                    length =(mask  < 0 ? 128 + mask : mask) * 4;
                } else {
                    in.resetReaderIndex();
                    length = (in.readIntLE() >> 8) * 4;
                }

                checkpoint(State.READ_MESSAGE);
            }
            case READ_MESSAGE: {

                ByteBuf result = in.readBytes(length);
                checkpoint(State.READ_LENGTH);
                out.add(result);
                break;
            }
            default:
                throw new Error("Shouldn't reach here.");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close connection when an exception is raised.
        if (cause instanceof ReadTimeoutException) {
            log.error("Close channel. Exit with error: Close channel [id: 0x" + Integer.toHexString(ctx.channel().hashCode()) + "] due inactivity");
        } else {
            log.error("Close channel. Exit with error: Close channel [id: 0x" + Integer.toHexString(ctx.channel().hashCode()) + "] " + cause.getMessage());
        }
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //Close connection when channel is inactive
        log.debug("Close inactive channel  [id: 0x" + ctx.channel().id() + "]");
        ctx.channel().close();
    }

    enum State {
        READ_LENGTH,
        READ_MESSAGE
    }
}
