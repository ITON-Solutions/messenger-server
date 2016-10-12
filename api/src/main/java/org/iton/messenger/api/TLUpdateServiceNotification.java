package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateServiceNotification extends Update {
    public static final int CLASS_ID = 0x382dd3e4;

    protected String message;

    public TLUpdateServiceNotification() {
    }

    public TLUpdateServiceNotification(String type, String message, MessageMedia media, boolean popup) {
        this.type    = type;
        this.message = message;
        this.media   = media;
        this.popup   = popup;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.type, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
        writeTLBool(this.popup, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.type    = readTLString(stream);
        this.message = readTLString(stream);
        this.media   = (MessageMedia) readTLObject(stream, context);
        this.popup   = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "updates.serviceNotification#382dd3e4";
    }
}