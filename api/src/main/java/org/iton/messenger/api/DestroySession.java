package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class DestroySession extends TLObject
{
    protected long session_id;

    public DestroySession(){}

    public DestroySession(long session_id) {
        this.session_id = session_id;
    }

    public long getSessionId() {
        return session_id;
    }

    public void setSessionId(long session_id) {
        this.session_id = session_id;
    }
}
