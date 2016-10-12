package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDialog extends TLObject {

    public static final int CLASS_ID = 0xc1dd804a;
    protected Peer peer;
    protected int top_message;
    protected int unread_count;
    protected int read_inbox_max_id;
    protected PeerNotifySettings notify_settings;
    protected int last_message_date;
    protected long id;
    protected int last_read;

    public TLDialog() {
    }

    public TLDialog(Peer peer,
                    int top_message,
                    int unread_count,
                    int read_inbox_max_id,
                    PeerNotifySettings notify_settings,
                    int last_message_date,
                    long id,
                    int last_read) {

        this.peer              = peer;
        this.top_message       = top_message;
        this.unread_count      = unread_count;
        this.read_inbox_max_id = read_inbox_max_id;
        this.notify_settings   = notify_settings;
        this.last_message_date = last_message_date;
        this.id                = id;
        this.last_read         = last_read;

    }

    public Peer getPeer() {
        return peer;
    }

    public void setPeer(Peer peer) {
        this.peer = peer;
    }

    public int getTopMessage() {
        return top_message;
    }

    public void setTopMessage(int top_message) {
        this.top_message = top_message;
    }

    public int getUnreadCount() {
        return unread_count;
    }

    public void setUnreadCount(int unread_count) {
        this.unread_count = unread_count;
    }

    public int getReadInboxMaxId() {
        return read_inbox_max_id;
    }

    public void setReadInboxMaxId(int read_inbox_max_id) {
        this.read_inbox_max_id = read_inbox_max_id;
    }

    public PeerNotifySettings getNotifySettings() {
        return notify_settings;
    }

    public void setNotifySettings(PeerNotifySettings notify_settings) {
        this.notify_settings = notify_settings;
    }

    public int getLastMessageDate() {
        return last_message_date;
    }

    public void setLastMessageDate(int last_message_date) {
        this.last_message_date = last_message_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLastRead() {
        return last_read;
    }

    public void setLastRead(int last_read) {
        this.last_read = last_read;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }



    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.peer, stream);
        writeInt(this.top_message, stream);
        writeInt(this.unread_count, stream);
        writeTLObject(this.notify_settings, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.peer            = (Peer) readTLObject(stream, context);
        this.top_message     = readInt(stream);
        this.unread_count    = readInt(stream);
        this.notify_settings = (PeerNotifySettings) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "dialog#c1dd804a";
    }

}