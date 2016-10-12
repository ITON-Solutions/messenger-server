package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLChatFull extends TLObject {
    public static final int CLASS_ID = 0x630e61be;

    protected int id;
    protected ChatParticipants participants;
    protected Photo chat_photo;
    protected PeerNotifySettings notify_settings;

    public TLChatFull() {
    }

    public TLChatFull(int id, ChatParticipants participants, Photo chat_photo, PeerNotifySettings notify_settings) {
        this.id              = id;
        this.participants    = participants;
        this.chat_photo      = chat_photo;
        this.notify_settings = notify_settings;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public ChatParticipants getParticipants() {
        return this.participants;
    }

    public void setParticipants(ChatParticipants participants) {
        this.participants = participants;
    }

    public Photo getChatPhoto() {
        return this.chat_photo;
    }

    public void setChatPhoto(Photo chat_photo) {
        this.chat_photo = chat_photo;
    }

    public PeerNotifySettings getNotifySettings() {
        return this.notify_settings;
    }

    public void setNotifySettings(PeerNotifySettings notify_settings) {
        this.notify_settings = notify_settings;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.id, stream);
        writeTLObject(this.participants, stream);
        writeTLObject(this.chat_photo, stream);
        writeTLObject(this.notify_settings, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id              = readInt(stream);
        this.participants    = (ChatParticipants) readTLObject(stream, context);
        this.chat_photo      = (Photo) readTLObject(stream, context);
        this.notify_settings = (PeerNotifySettings) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "chatFull#630e61be";
    }
}