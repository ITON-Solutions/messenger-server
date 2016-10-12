package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLVector;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDocument extends Document {
    public static final int CLASS_ID = 0xf9a39f4f;


    public TLDocument() {
    }

    public TLDocument(long id,
                      long access_hash,
                      int date,
                      String mime_type,
                      int size,
                      PhotoSize thumb,
                      int dc_id,
                      TLVector<DocumentAttribute> attributes) {

        this.id          = id;
        this.access_hash = access_hash;
        this.date        = date;
        this.mime_type   = mime_type;
        this.size        = size;
        this.thumb       = thumb;
        this.dc_id       = dc_id;
        this.attributes  = attributes;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(this.id, stream);
        writeLong(this.access_hash, stream);
        writeInt(this.date, stream);
        writeTLString(this.mime_type, stream);
        writeInt(this.size, stream);
        writeTLObject(this.thumb, stream);
        writeInt(this.dc_id, stream);
        writeTLVector(this.attributes, stream);

    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context)  throws IOException {

        this.id          = readLong(stream);
        this.access_hash = readLong(stream);
        this.date        = readInt(stream);
        this.mime_type   = readTLString(stream);
        this.size        = readInt(stream);
        this.thumb       = (PhotoSize) readTLObject(stream, context);
        this.dc_id       = readInt(stream);
        this.attributes  = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "document#f9a39f4f";
    }
}