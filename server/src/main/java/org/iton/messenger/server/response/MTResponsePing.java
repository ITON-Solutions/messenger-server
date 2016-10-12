package org.iton.messenger.server.response;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.proto.tl.MTMessage;
import org.iton.messenger.proto.tl.TLMessagesAck;
import org.iton.messenger.proto.tl.TLMessagesContainer;
import org.iton.messenger.proto.tl.TLPing;
import org.iton.messenger.proto.tl.TLPong;

import java.io.IOException;

/**
 * Created by ITON Solutions on 8/26/15.
 */
public class MTResponsePing extends MTResponse<TLPing> {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTResponsePing.class);

    public MTResponsePing(ChannelHandlerContext ctx) {
        super(ctx);
    }

    @Override
    public MTMessage process(int layer, long messageId, TLPing command) throws IOException {

        long pingId = command.getPingId();

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

        log.debug("Response pong to ping message_id=" + responseId);
        return response;
    }


}
