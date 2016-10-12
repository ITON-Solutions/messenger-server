package org.iton.messenger.server.services.session;

import io.netty.channel.Channel;
import org.iton.messenger.server.session.MTSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by ITON Solutions on 9/1/15.
 */
public interface IMTSessionManager {

    public List<MTSession> getAllMTSessions();

    public List<Channel> getChannels(int user_id) throws IOException;

    public MTSession getMTSession(Channel channel);

    public boolean addChannel(Channel channel);

    public void addMTSession(Channel channel, MTSession session) throws IOException;

    public List<Channel> getChannels(byte[] sessionId)  throws IOException;

}
