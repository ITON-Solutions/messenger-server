package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class GeoChatMessage extends TLObject
{
    protected int chat_id;
    protected int id;
    protected int from_id;
    protected int date;
    protected String message;
    protected MessageMedia media;
    protected MessageAction action;

    public int getChatId() {
        return chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromId() {
        return from_id;
    }

    public void setFromId(int from_id) {
        this.from_id = from_id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageMedia getMedia() {
        return media;
    }

    public void setMedia(MessageMedia media) {
        this.media = media;
    }

    public MessageAction getAction() {
        return action;
    }

    public void setAction(MessageAction action) {
        this.action = action;
    }
}
