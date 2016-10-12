package org.iton.messenger.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.AttributeKey;
import org.apache.commons.configuration.Configuration;
import org.iton.messenger.server.session.MTSession;
import org.iton.messenger.server.services.config.CFGService;

/**
 * Created by ITON on 8/22/14.
 */
public class MessengerServer {

    private static final Configuration config = CFGService.getInstance().getConfiguration();
    private static final int PORT             = config.getInt("server.port", 8000);
    private static final String HOST          = config.getString("server.host", "localhost");

    public static final AttributeKey<MTSession> SESSION = AttributeKey.valueOf("session");

    public static void main(String[] args) throws Exception
    {
        EventLoopGroup bossGroup   = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                     .channel(NioServerSocketChannel.class)
                     .handler(new LoggingHandler(LogLevel.INFO))
                     .childHandler(new ServerInitializer())
                     .option(ChannelOption.SO_BACKLOG, 128)
                     .childOption(ChannelOption.SO_KEEPALIVE, true);

            bootstrap.bind(HOST, PORT).sync().channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
