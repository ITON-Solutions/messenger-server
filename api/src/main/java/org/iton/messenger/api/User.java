package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class User extends TLObject {

    protected int id;
    protected String first_name;
    protected String last_name;
    protected String username;
    protected long access_hash;
    protected String phone;
    protected UserProfilePhoto photo;
    protected UserStatus status;
    protected boolean inactive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getAccessHash() {
        return access_hash;
    }

    public void setAccessHash(long access_hash) {
        this.access_hash = access_hash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(UserProfilePhoto photo) {
        this.photo = photo;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }
}
