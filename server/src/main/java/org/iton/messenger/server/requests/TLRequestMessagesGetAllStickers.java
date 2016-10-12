package org.iton.messenger.server.requests;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.messages.Stickers;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLMethod;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLRequestMessagesGetAllStickers extends TLMethod<Stickers> {

    public static final int CLASS_ID = 0xaa3bc868;

    protected String  hash;


    public TLRequestMessagesGetAllStickers() {}

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLRequestMessagesGetAllStickers(String hash) {
        this.hash = hash;
      }

    @Override
    public Stickers deserializeResponse(ByteBuf stream, TLContext context) throws IOException {
        TLObject res = readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof Stickers))
            return (Stickers) res;
        throw new IOException("Incorrect response type. Expected Stickers, got: " + res.getClass().getCanonicalName());
    }


    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.hash, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.hash = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messages.getAllStickers#aa3bc868";
    }
}