package org.iton.messenger.server;

/**
 * Created by ITON on 8/30/14.
 */

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.iton.messenger.server.proto.MTProtocolDecoder;

public final class ServerInitializer extends ChannelInitializer<SocketChannel>
{
    @Override
    public void initChannel(SocketChannel channel) throws Exception
    {
        ChannelPipeline pipeline = channel.pipeline();
        //pipeline.addFirst(new LoggingHandler(LogLevel.INFO));
        pipeline.addLast(new MTProtocolDecoder());
    }
}
