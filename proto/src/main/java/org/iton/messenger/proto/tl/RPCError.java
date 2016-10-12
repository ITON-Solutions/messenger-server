package org.iton.messenger.proto.tl;

import org.iton.messenger.core.TLObject;

/**
 * Created by ITON Solutions on 8/24/16.
 */
public abstract class RPCError extends TLObject {

    protected int error_code;
    protected String error_message;
    protected long query_id;

    public int getErrorCode() {
        return error_code;
    }

    public void setErrorCode(int error_code) {
        this.error_code = error_code;
    }

    public String getErrorMessage() {
        return error_message;
    }

    public void setErrorMessage(String error_message) {
        this.error_message = error_message;
    }

    public long getQueryId() {
        return query_id;
    }

    public void setQueryId(long query_id) {
        this.query_id = query_id;
    }
}
