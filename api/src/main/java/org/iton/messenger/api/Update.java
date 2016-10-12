package org.iton.messenger.api;

import org.iton.messenger.api.contacts.ContactLink;
import org.iton.messenger.core.TLIntVector;
import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class Update extends TLObject {
    protected int chat_id;
    protected int max_date;
    protected int date;
    protected int user_id;
    protected ContactLink my_link;
    protected ContactLink foreign_link;
    protected TLIntVector messages = new TLIntVector();
    protected int pts;
    protected int pts_count;
    protected int max_id;
    protected int version;
    protected WebPage webpage;
    protected String type;
    protected MessageMedia media;
    protected boolean popup;
    protected NotifyPeer peer;
    protected PeerNotifySettings notify_settings;
    protected SendMessageAction action;
    protected String first_name;
    protected String last_name;
    protected String username;
    protected String phone;
    protected int qts;
    protected int id;
    protected long random_id;
    protected TLVector<TLDcOption> dc_options = new TLVector<>();
    protected ChatParticipants participants;
    protected TLPrivacyKeyStatusTimestamp key;
    protected TLVector<PrivacyRule> rules = new TLVector<>();
    protected EncryptedChat chat;
    protected boolean blocked;
    protected long auth_key_id;
    protected String device;
    protected String location;
    protected UserProfilePhoto photo;
    protected boolean previous;
    protected int inviter_id;
    protected UserStatus status;

    public int getChatId() {
        return chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getMaxDate() {
        return max_date;
    }

    public void setMaxDate(int max_date) {
        this.max_date = max_date;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public ContactLink getMyLink() {
        return my_link;
    }

    public void setMyLink(ContactLink my_link) {
        this.my_link = my_link;
    }

    public ContactLink getForeignLink() {
        return foreign_link;
    }

    public void setForeignLink(ContactLink foreign_link) {
        this.foreign_link = foreign_link;
    }

    public TLIntVector getMessages() {
        return messages;
    }

    public void setMessages(TLIntVector messages) {
        this.messages = messages;
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

    public int getMaxId() {
        return max_id;
    }

    public void setMaxId(int max_id) {
        this.max_id = max_id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public WebPage getWebpage() {
        return webpage;
    }

    public void setWebpage(WebPage webpage) {
        this.webpage = webpage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MessageMedia getMedia() {
        return media;
    }

    public void setMedia(MessageMedia media) {
        this.media = media;
    }

    public boolean isPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public NotifyPeer getNotifyPeer() {
        return peer;
    }

    public void setNotifyPeer(NotifyPeer peer) {
        this.peer = peer;
    }

    public PeerNotifySettings getNotifySettings() {
        return notify_settings;
    }

    public void setNotifySettings(PeerNotifySettings notify_settings) {
        this.notify_settings = notify_settings;
    }

    public SendMessageAction getAction() {
        return action;
    }

    public void setAction(SendMessageAction action) {
        this.action = action;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRandomId() {
        return random_id;
    }

    public void setRandomId(long random_id) {
        this.random_id = random_id;
    }

    public TLVector<TLDcOption> getDcOptions() {
        return dc_options;
    }

    public void setDcOptions(TLVector<TLDcOption> dc_options) {
        this.dc_options = dc_options;
    }

    public ChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(ChatParticipants participants) {
        this.participants = participants;
    }

    public TLPrivacyKeyStatusTimestamp getKey() {
        return key;
    }

    public void setKey(TLPrivacyKeyStatusTimestamp key) {
        this.key = key;
    }

    public TLVector<PrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<PrivacyRule> rules) {
        this.rules = rules;
    }

    public EncryptedChat getChat() {
        return chat;
    }

    public void setChat(EncryptedChat chat) {
        this.chat = chat;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public long getAuthKeyId() {
        return auth_key_id;
    }

    public void setAuthKeyId(long auth_key_id) {
        this.auth_key_id = auth_key_id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(UserProfilePhoto photo) {
        this.photo = photo;
    }

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }

    public int getInviterId() {
        return inviter_id;
    }

    public void setInviterId(int inviter_id) {
        this.inviter_id = inviter_id;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
