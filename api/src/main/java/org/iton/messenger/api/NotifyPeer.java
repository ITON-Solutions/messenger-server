package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class NotifyPeer extends TLObject
{
    protected Peer peer;

    public Peer getPeer() {
        return peer;
    }

    public void setPeer(Peer peer) {
        this.peer = peer;
    }
}
