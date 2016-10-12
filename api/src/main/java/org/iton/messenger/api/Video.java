package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class Video extends TLObject {
    protected long id;
    protected long access_hash;
    protected int user_id;
    protected int date;
    protected String caption;
    protected int duration;
    protected String mime_type;
    protected int size;
    protected PhotoSize thumb;
    protected int dc_id;
    protected int w;
    protected int h;
    protected byte[] key;
    protected byte[] iv;
    protected VideoEditedInfo videoEditedInfo = null;
}
