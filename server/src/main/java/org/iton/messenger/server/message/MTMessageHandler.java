package org.iton.messenger.server.message;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.proto.tl.*;
import org.iton.messenger.server.TLProtoContext;
import org.iton.messenger.server.response.MTResponsePing;
import org.iton.messenger.server.response.MTResponsePingDelayDisconnect;
import org.iton.messenger.server.services.session.IMTSessionManager;
import org.iton.messenger.server.services.session.MTSessionManager;
import org.iton.messenger.server.session.MTSession;

import java.io.IOException;
import java.util.Set;

/**
 * Created by ITON on 9/7/14.
 */
public class MTMessageHandler extends SimpleChannelInboundHandler<MTMessage> {

    private static final InternalLogger log        = InternalLoggerFactory.getInstance(MTMessageHandler.class);
    private static final IMTSessionManager manager = MTSessionManager.getInstance();
    private static final TLContext context         = new TLProtoContext();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MTMessage message) throws Exception {

        TLObject content = context.deserializeMessage(message.getContent());

        if(content instanceof TLMessagesContainer){
            TLMessagesContainer container = (TLMessagesContainer) content;
            Set<MTMessage> messages = container.getMessages();
            for(MTMessage item: messages){
                TLObject object = context.deserializeMessage(item.getContent());
                process(ctx, item.getMessageId(), item.getSeqNo(), object);
            }
        } else {
            process(ctx, message.getMessageId(), message.getSeqNo(), content);
        }
    }

    private void process(ChannelHandlerContext ctx, long messageId, int seqNum, TLObject object) throws IOException {

        switch(object.getClassId()){
            case TLPing.CLASS_ID:
                log.debug("Request ping");
                ping(ctx, messageId, (TLPing) object);
                break;
            case TLMessagesAck.CLASS_ID:
                log.debug("Request messages_ack");
                ack(ctx, (TLMessagesAck) object);
                break;
            case TLPingDelayDisconnect.CLASS_ID:
                log.debug("Request pingDelayDisconnect");
                pingDelay(ctx, messageId, (TLPingDelayDisconnect) object);
                break;
             default:
                log.error("Not recognized proto message: 0x" + Integer.toHexString(object.getClassId()));
        }
    }

    private void ack(ChannelHandlerContext ctx, TLMessagesAck ack) {
        MTSession session = manager.getMTSession(ctx.channel());
        ack.getMessages().forEach(session::isMessageConfirmed);
    }

    private void ping(ChannelHandlerContext ctx, long messageId, TLPing ping) throws IOException {
        MTMessage response = new MTResponsePing(ctx).process(messageId, ping);
        ctx.channel().writeAndFlush(response);
    }

    private void pingDelay(ChannelHandlerContext ctx, long messageId, TLPingDelayDisconnect command) throws IOException {
        MTMessage response = new MTResponsePingDelayDisconnect(ctx).process(messageId, command);
        ctx.channel().writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        log.error("Close channel: " + ctx.channel(), cause);
        ctx.close();
    }
}
