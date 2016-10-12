package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.api.contacts.TLContactsLink;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLUserFull extends TLObject {
    public static final int CLASS_ID = 0x771095da;
    protected User user;
    protected TLContactsLink link;
    protected Photo profile_photo;
    protected PeerNotifySettings notify_settings;
    protected boolean blocked;
    protected String real_first_name;
    protected String real_last_name;

    public TLUserFull() {
    }

    public TLUserFull(User user, TLContactsLink link, Photo profile_photo, PeerNotifySettings notify_settings, boolean blocked, String real_first_name, String real_last_name) {
        this.user            = user;
        this.link            = link;
        this.profile_photo   = profile_photo;
        this.notify_settings = notify_settings;
        this.blocked         = blocked;
        this.real_first_name = real_first_name;
        this.real_last_name  = real_last_name;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TLContactsLink getLink() {
        return this.link;
    }

    public void setLink(TLContactsLink link) {
        this.link = link;
    }

    public Photo getProfilePhoto() {
        return this.profile_photo;
    }

    public void setProfilePhoto(Photo profile_photo) {
        this.profile_photo = profile_photo;
    }

    public PeerNotifySettings getNotifySettings() {
        return this.notify_settings;
    }

    public void setNotifySettings(PeerNotifySettings notify_settings) {
        this.notify_settings = notify_settings;
    }

    public boolean getBlocked() {
        return this.blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getRealFirstName() {
        return this.real_first_name;
    }

    public void setRealFirstName(String real_first_name) {
        this.real_first_name = real_first_name;
    }

    public String getRealLastName() {
        return this.real_last_name;
    }

    public void setRealLastName(String real_last_name) {
        this.real_last_name = real_last_name;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeTLObject(this.user, stream);
        writeTLObject(this.link, stream);
        writeTLObject(this.profile_photo, stream);
        writeTLObject(this.notify_settings, stream);
        writeTLBool(this.blocked, stream);
        writeTLString(this.real_first_name, stream);
        writeTLString(this.real_last_name, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.user            = (User) readTLObject(stream, context);
        this.link            = (TLContactsLink) readTLObject(stream, context);
        this.profile_photo   = (Photo) readTLObject(stream, context);
        this.notify_settings = (PeerNotifySettings) readTLObject(stream, context);
        this.blocked         = readTLBool(stream);
        this.real_first_name = readTLString(stream);
        this.real_last_name  = readTLString(stream);
    }

    @Override
    public String toString() {
        return "userFull#771095da";
    }
}