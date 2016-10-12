package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLWebPage extends WebPage {
    public static final int CLASS_ID = 0xa31ea0b5;


    public TLWebPage() {
    }

    public TLWebPage(long id,
                     int flags,
                     String url,
                     String display_url,
                     String type,
                     String site_name,
                     String title,
                     String description,
                     Photo photo,
                     String embed_url,
                     String embed_type,
                     int embed_width,
                     int embed_height,
                     int duration,
                     String author) {

        this.id           = id;
        this.flags        = flags;
        this.url          = url;
        this.display_url  = display_url;
        this.type         = type;
        this.site_name    = site_name;
        this.title        = title;
        this.description  = description;
        this.photo        = photo;
        this.embed_url    = embed_url;
        this.embed_type   = embed_type;
        this.embed_width  = embed_width;
        this.embed_height = embed_height;
        this.duration     = duration;
        this.author       = author;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {

        writeInt(this.flags, stream);
        writeLong(this.id, stream);
        writeTLString(this.url, stream);
        writeTLString(this.display_url, stream);

        if ((flags & 1) != 0) {
            writeTLString(this.type, stream);
        }
        if ((flags & 2) != 0) {
            writeTLString(this.site_name, stream);
        }
        if ((flags & 4) != 0) {
            writeTLString(this.title, stream);
        }
        if ((flags & 8) != 0) {
            writeTLString(description, stream);
        }
        if ((flags & 16) != 0) {
            writeTLObject(this.photo, stream);
        }
        if ((flags & 32) != 0) {
            writeTLString(this.embed_url, stream);
            writeTLString(this.embed_type, stream);
        }
        if ((flags & 64) != 0) {
            writeInt(this.embed_width, stream);
            writeInt(this.embed_height, stream);
        }
        if ((flags & 128) != 0) {
            writeInt(this.duration, stream);
        }
        if ((flags & 256) != 0) {
            writeTLString(this.author, stream);
        }
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {

        flags       = readInt(stream);
        id          = readLong(stream);
        url         = readTLString(stream);
        display_url = readTLString(stream);

        if ((flags & 1) != 0) {
            type = readTLString(stream);
        }
        if ((flags & 2) != 0) {
            site_name = readTLString(stream);
        }
        if ((flags & 4) != 0) {
            title = readTLString(stream);
        }
        if ((flags & 8) != 0) {
            description = readTLString(stream);
        }
        if ((flags & 16) != 0) {
            photo = ((Photo) readTLObject(stream, context));
        }
        if ((flags & 32) != 0) {
            embed_url  =  readTLString(stream);
            embed_type =  readTLString(stream);
        }
        if ((flags & 64) != 0) {
            embed_width  = readInt(stream);
            embed_height = readInt(stream);
        }
        if ((flags & 128) != 0) {
            duration = readInt(stream);
        }
        if ((flags & 256) != 0) {
            author =  readTLString(stream);
        }

    }

    @Override
    public String toString() {
        return "webpage#a31ea0b5";
    }
}

