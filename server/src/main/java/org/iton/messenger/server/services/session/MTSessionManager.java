package org.iton.messenger.server.services.session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.server.MessengerServer;
import org.iton.messenger.server.session.MTSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.iton.messenger.proto.secure.CryptoUtils.arrayEq;

/**
 * Created by ITON Solutions on 8/29/15.
 */
public class MTSessionManager implements IMTSessionManager {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTSessionManager.class);

    private static volatile ChannelGroup channels      = null;
    private static volatile IMTSessionManager instance = null;

    public static IMTSessionManager getInstance() {
        IMTSessionManager local = instance;
        if (local == null) {
            synchronized (MTSessionManager.class) {
                local = instance;
                if (local == null) {
                    instance = local = new MTSessionManager();
                }
                channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
            }
        }
        return local;
    }

    @Override
    public List<Channel> getChannels(int user_id) throws IOException {

        List<Channel> result = new ArrayList<>();
        for (Channel channel : channels) {
            MTSession session = channel.attr(MessengerServer.SESSION).get();
            if (session.getUser() != null && session.getUser().getId() == user_id) {
                result.add(channel);
            }
        }
        return result;
    }

    @Override
    public List<Channel> getChannels(byte[] sessionId) {
        List<Channel> result = new ArrayList<>();
        for (Channel channel : channels) {
            MTSession session = channel.attr(MessengerServer.SESSION).get();
            if (session != null && arrayEq(session.getSessionId(), sessionId)) {
                result.add(channel);
            }
        }
        return result;
    }

    @Override
    public boolean addChannel(Channel channel) {
        if(!channels.contains(channel)) {
            return channels.add(channel);
        }
        log.debug("Channel " + channel + " already exists");
        return false;
    }

    @Override
    public List<MTSession> getAllMTSessions() {
        List<MTSession> sessions = new ArrayList<>();
        for (Channel channel : channels) {
            MTSession session = channel.attr(MessengerServer.SESSION).get();
            if(session != null) {
                sessions.add(session);
            }
        }
        return sessions;
    }

    @Override
    public MTSession getMTSession(Channel channel) {

         if(channels.contains(channel)) {
            MTSession session = channel.attr(MessengerServer.SESSION).get();
            if (session != null) {
                session.setLastAccessTime(System.currentTimeMillis());
            }
            return session;
        }
        return null;
    }

    @Override
    public synchronized void addMTSession(Channel channel, MTSession session) throws IOException {

        channels.stream().filter(item -> !item.isActive()).forEach(ChannelOutboundInvoker::close);

        MTSession result = channel.attr(MessengerServer.SESSION).get();
        if(result == null || !session.equals(result) ) {
            channel.attr(MessengerServer.SESSION).set(session);
        }
    }
}