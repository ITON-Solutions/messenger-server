package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;


public abstract class AccountPassword extends TLObject {
    protected byte[] current_salt;
    protected byte[] new_salt;
    protected String hint;
    protected boolean has_recovery;
    protected String email_unconfirmed_pattern;

    public byte[] getCurrentSalt() {
        return current_salt;
    }

    public void setCurrentSalt(byte[] current_salt) {
        this.current_salt = current_salt;
    }

    public byte[] getNewSalt() {
        return new_salt;
    }

    public void setNewSalt(byte[] new_salt) {
        this.new_salt = new_salt;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isHasRecovery() {
        return has_recovery;
    }

    public void setHasRecovery(boolean has_recovery) {
        this.has_recovery = has_recovery;
    }

    public String getEmailUnconfirmedPattern() {
        return email_unconfirmed_pattern;
    }

    public void setEmailUnconfirmedPattern(String email_unconfirmed_pattern) {
        this.email_unconfirmed_pattern = email_unconfirmed_pattern;
    }
}
