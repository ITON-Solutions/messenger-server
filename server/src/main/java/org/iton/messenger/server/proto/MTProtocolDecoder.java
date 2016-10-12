package org.iton.messenger.server.proto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.server.services.session.MTSessionManager;
import org.iton.messenger.server.services.session.IMTSessionManager;

import java.util.List;

/**
 * Created by ITON on 9/1/14.
 */
public class MTProtocolDecoder extends ByteToMessageDecoder
{
    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTProtocolDecoder.class);
    private static final IMTSessionManager manager = MTSessionManager.getInstance();

    private static final int ABRIDGED = 0xEF;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if(in instanceof EmptyByteBuf){
            return;
        }

        ChannelPipeline pipeline = ctx.pipeline();

        int protocol = in.readByte() & 0xFF;

        switch(protocol)
        {
            case ABRIDGED:
                log.debug("Use abridged protocol");
                pipeline.addLast(new MTRequestDecoder());
                break;
            default:
                throw new Error("Shouldn't reach here.");
        }

        pipeline.addLast(new MTMessageDecoder());
        out.add(in.retain());
        pipeline.remove(this);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close connection when an exception is raised.
        log.error("Close channel. Exit with error: " + cause.getMessage());
        ctx.close();
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        manager.addChannel(ctx.channel());
    }
}
