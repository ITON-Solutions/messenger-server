package org.iton.messenger.api.help;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.utils.StreamingUtils;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

public class TLInviteText extends TLObject {
    public static final int CLASS_ID = 0x18cb9f78;
    protected String message;

    public TLInviteText() {
    }

    public TLInviteText(String _message) {
        this.message = _message;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        StreamingUtils.writeTLString(this.message, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.message = StreamingUtils.readTLString(stream);
    }

    @Override
    public String toString() {
        return "help.inviteText#18cb9f78";
    }
}