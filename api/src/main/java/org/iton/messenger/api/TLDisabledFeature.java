package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readTLString;
import static org.iton.messenger.core.utils.StreamingUtils.writeTLString;

/**
 * Created by ITON Solutions on 7/27/15.
 */
public class TLDisabledFeature extends TLObject {
    public static final int CLASS_ID = 0xae636f24;
    protected String feature;
    protected String description;

    public TLDisabledFeature() {
    }

    public TLDisabledFeature(String feature, String description) {
        this.feature     = feature;
        this.description = description;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getFeature() {
        return this.feature;
    }

    public void setFeature(String value) {
        this.feature = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLString(this.feature, stream);
        writeTLString(this.description, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.feature     = readTLString(stream);
        this.description = readTLString(stream);
    }

    @Override
    public String toString() {
        return "disabledFeature#ae636f24";
    }
}

