package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class Message extends TLObject {

    public static final int MESSAGE_FLAG_UNREAD  = 1;
    public static final int MESSAGE_FLAG_OUT     = 2;
    public static final int MESSAGE_FLAG_FWD     = 4;
    public static final int MESSAGE_FLAG_REPLY   = 8;
    public static final int MESSAGE_FLAG_MENTION = 16;
    public static final int LAYER                = 27;


    protected int flags;
    protected int id;
    protected int fwd_from_id;
    protected int fwd_date;
    protected int from_id;
    protected Peer to_id;
    protected int date;
    protected String message = "-1";
    protected MessageMedia media;
    protected int reply_to_msg_id;
    protected MessageAction action;
    protected int send_state = 0;
    protected int fwd_msg_id = 0;
    protected String attach_path = "";
    protected long random_id;
    protected int local_id = 0;
    protected long dialog_id;
    protected int ttl;
    protected int destroyTime;
    protected int layer;
    protected int seq_in;
    protected int seq_out;
    protected Message replyMessage;
    protected VideoEditedInfo videoEditedInfo = null;

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

    public int getFromId() {
        return from_id;
    }

    public void setFromId(int from_id) {
        this.from_id = from_id;
    }

    public Peer getToId() {
        return to_id;
    }

    public void setToId(Peer to_id) {
        this.to_id = to_id;
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

    public int getReplyToMsgId() {
        return reply_to_msg_id;
    }

    public void setReplyToMsgId(int reply_to_msg_id) {
        this.reply_to_msg_id = reply_to_msg_id;
    }

    public MessageAction getAction() {
        return action;
    }

    public void setAction(MessageAction action) {
        this.action = action;
    }

    public int getSendState() {
        return send_state;
    }

    public void setSendState(int send_state) {
        this.send_state = send_state;
    }

    public int getFwdMsgId() {
        return fwd_msg_id;
    }

    public void setFwdMsgId(int fwd_msg_id) {
        this.fwd_msg_id = fwd_msg_id;
    }

    public String getAttachPath() {
        return attach_path;
    }

    public void setAttachPath(String attach_path) {
        this.attach_path = attach_path;
    }

    public long getRandomId() {
        return random_id;
    }

    public void setRandomId(long random_id) {
        this.random_id = random_id;
    }

    public int getLocalId() {
        return local_id;
    }

    public void setLocalId(int local_id) {
        this.local_id = local_id;
    }

    public long getDialogId() {
        return dialog_id;
    }

    public void setDialogId(long dialog_id) {
        this.dialog_id = dialog_id;
    }

    public int getTTL() {
        return ttl;
    }

    public void setTTL(int ttl) {
        this.ttl = ttl;
    }

    public int getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(int destroyTime) {
        this.destroyTime = destroyTime;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getSeqIn() {
        return seq_in;
    }

    public void setSeqIn(int seq_in) {
        this.seq_in = seq_in;
    }

    public int getSeqOut() {
        return seq_out;
    }

    public void setSeqOut(int seq_out) {
        this.seq_out = seq_out;
    }

    public Message getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(Message replyMessage) {
        this.replyMessage = replyMessage;
    }

    public VideoEditedInfo getVideoEditedInfo() {
        return videoEditedInfo;
    }

    public void setVideoEditedInfo(VideoEditedInfo videoEditedInfo) {
        this.videoEditedInfo = videoEditedInfo;
    }
}

