package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class MessageAction extends TLObject
{
    protected Photo photo;
    protected UserProfilePhoto userPhoto;
    protected int user_id;
    protected String title;
    protected TLVector<Integer> users = new TLVector<>();
    protected String address;
    protected int ttl;
    protected DecryptedMessageAction encryptedAction;

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public UserProfilePhoto getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(UserProfilePhoto userPhoto) {
        this.userPhoto = userPhoto;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLVector<Integer> getUsers() {
        return users;
    }

    public void setUsers(TLVector<Integer> users) {
        this.users = users;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTTL() {
        return ttl;
    }

    public void setTTL(int ttl) {
        this.ttl = ttl;
    }

    public DecryptedMessageAction getEncryptedAction() {
        return encryptedAction;
    }

    public void setEncryptedAction(DecryptedMessageAction encryptedAction) {
        this.encryptedAction = encryptedAction;
    }
}
