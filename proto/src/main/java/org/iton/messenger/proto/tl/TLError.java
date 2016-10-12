package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class TLError extends TLObject {

    public static final int CLASS_ID = 0xc4b9f9bb;

    protected int code;
    protected String text;

    public TLError(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public TLError() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(code, stream);
        writeTLString(text, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.code = readInt(stream);
        this.text = readTLString(stream);
    }

    @Override
    public String toString() {
        return "error#c4b9f9bb";
    }
}
