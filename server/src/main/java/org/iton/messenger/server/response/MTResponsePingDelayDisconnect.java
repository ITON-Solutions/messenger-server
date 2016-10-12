package org.iton.messenger.server.response;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.server.services.config.CFGService;
import org.iton.messenger.server.services.session.MTSessionManager;
import org.apache.commons.configuration.Configuration;
import org.iton.messenger.server.session.MTSession;
import org.iton.messenger.proto.tl.MTMessage;
import org.iton.messenger.proto.tl.TLMessagesAck;
import org.iton.messenger.proto.tl.TLMessagesContainer;
import org.iton.messenger.proto.tl.TLPingDelayDisconnect;
import org.iton.messenger.proto.tl.TLPong;

import java.io.IOException;

/**
 * Created by ITON Solutions on 8/26/15.
 */
public class MTResponsePingDelayDisconnect extends MTResponse<TLPingDelayDisconnect> {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTResponsePingDelayDisconnect.class);
    private static final Configuration cfg  = CFGService.getInstance().getConfiguration();

    public MTResponsePingDelayDisconnect(ChannelHandlerContext ctx) {
        super(ctx);
    }

    @Override
    public MTMessage process(int layer, long messageId, TLPingDelayDisconnect command) throws IOException {

        int delay   = command.getDisconnectDelay();
        long pingId = command.getPingId();

        log.debug("Delay disconnect: " + delay + " channel: [id: 0x" + ctx.channel().id() + "]");

        if(delay > cfg.getInt("connection.regular.delay")){
            session.setPushConnection(true);
        } else {
            session.setPushConnection(false);
        }

        for(MTSession session : MTSessionManager.getInstance().getAllMTSessions()) {
            log.debug("Session: " + session.toString() + " is push: " + session.isPushConnection());
        }

        return response(messageId, pingId);
    }

    private MTMessage response(long messageId, long pingId) throws IOException {

        TLMessagesContainer container = new TLMessagesContainer();

        responseId = session.getMessageId(true);
        session.addMessageToConfirm(responseId);

        TLPong pong       = new TLPong(responseId, pingId);
        TLMessagesAck ack = new TLMessagesAck(new long[] {messageId});

        container.getMessages().add(new MTMessage(responseId, session.getSeqNum(true), pong.serialize()));
        container.getMessages().add(new MTMessage(session.getMessageId(false), session.getSeqNum(false), ack.serialize()));

        MTMessage response = new MTMessage(session.getMessageId(false),  session.getSeqNum(false), container.serialize());

        log.debug("Response pong to pingDelayDisconnect message_id=" + responseId);
        return response;
    }

}
