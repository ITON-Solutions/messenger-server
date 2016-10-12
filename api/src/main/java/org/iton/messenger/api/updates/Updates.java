package org.iton.messenger.api.updates;

import org.iton.messenger.api.Chat;
import org.iton.messenger.api.Update;
import org.iton.messenger.api.User;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Updates extends TLObject {
    protected int flags;
    protected int id;
    protected int chat_id;
    protected String message;
    protected int pts;
    protected int pts_count;
    protected int date;
    protected int fwd_from_id;
    protected int fwd_date;
    protected int reply_to_msg_id;
    protected TLVector<Update> updates = new TLVector<>();
    protected TLVector<User> users = new TLVector<>();
    protected TLVector<Chat> chats = new TLVector<>();
    protected int seq;
    protected int user_id;
    protected Update update;
    protected int seq_start;
    protected int qts;

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatId() {
        return chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return pts_count;
    }

    public void setPtsCount(int pts_count) {
        this.pts_count = pts_count;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getFwdFromId() {
        return fwd_from_id;
    }

    public void setFwdFromId(int fwd_from_id) {
        this.fwd_from_id = fwd_from_id;
    }

    public int getFwdDate() {
        return fwd_date;
    }

    public void setFwdDate(int fwd_date) {
        this.fwd_date = fwd_date;
    }

    public int getReplyToMsgId() {
        return reply_to_msg_id;
    }

    public void setReplyToMsgId(int reply_to_msg_id) {
        this.reply_to_msg_id = reply_to_msg_id;
    }

    public TLVector<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(TLVector<Update> updates) {
        this.updates = updates;
    }

    public TLVector<User> getUsers() {
        return users;
    }

    public void setUsers(TLVector<User> users) {
        this.users = users;
    }

    public TLVector<Chat> getChats() {
        return chats;
    }

    public void setChats(TLVector<Chat> chats) {
        this.chats = chats;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public int getSeqStart() {
        return seq_start;
    }

    public void setSeqStart(int seq_start) {
        this.seq_start = seq_start;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
