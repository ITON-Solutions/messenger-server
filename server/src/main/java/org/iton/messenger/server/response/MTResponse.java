package org.iton.messenger.server.response;

import io.netty.channel.ChannelHandlerContext;
import org.iton.messenger.server.TLProtoContext;
import org.iton.messenger.server.services.session.MTSessionManager;
import org.iton.messenger.server.services.session.IMTSessionManager;
import org.iton.messenger.server.session.MTSession;
import org.iton.messenger.proto.tl.MTMessage;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

/**
 * Created by ITON Solutions on 8/26/15.
 */
public abstract class MTResponse<T extends TLObject> {

    private static final IMTSessionManager manager = MTSessionManager.getInstance();

    protected ChannelHandlerContext ctx = null;
    protected MTSession session         = null;
    protected TLContext proto           = new TLProtoContext();

    long responseId;

    public MTResponse (ChannelHandlerContext ctx){
        this.ctx     = ctx;
        this.session = manager.getMTSession(this.ctx.channel());
    }

    public abstract MTMessage process(int layer, long messageId, T command) throws IOException;

    public MTMessage process(long messageId, T command) throws IOException {
        return this.process(0, messageId, command);
    }

}
