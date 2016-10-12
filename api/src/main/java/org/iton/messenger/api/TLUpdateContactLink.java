package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.contacts.ContactLink;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUpdateContactLink extends Update {
    public static final int CLASS_ID = 0x9d2e67c5;


    public TLUpdateContactLink() {
    }

    public TLUpdateContactLink(int user_id, ContactLink my_link, ContactLink foreign_link) {
        this.user_id      = user_id;
        this.my_link      = my_link;
        this.foreign_link = foreign_link;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeInt(this.user_id, stream);
        writeTLObject(this.my_link, stream);
        writeTLObject(this.foreign_link, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user_id      = readInt(stream);
        this.my_link      = (ContactLink) readTLObject(stream, context);
        this.foreign_link = (ContactLink) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "updateContactLink#9d2e67c5";
    }
}
