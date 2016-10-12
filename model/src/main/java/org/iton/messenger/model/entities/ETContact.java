package org.iton.messenger.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ITON Solutions on 8/23/15.
 */
@Entity
@Table(name = "telegram_contacts")
public class ETContact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private ETUser user;

    @Column(name = "contact_id")
    private Integer contact_id;

    @Column(name = "created")
    private Timestamp created;

    public ETContact() {

    }

    public ETContact(ETUser user, Integer contact_id){
        this.user       = user;
        this.contact_id = contact_id;
        this.created    = new Timestamp(System.currentTimeMillis());

    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public ETUser getUser() {
        return user;
    }

    public void setUser(ETUser user) {
        this.user = user;
    }

    public Integer getContactId() {
        return contact_id;
    }

    public void setContactId(Integer contact_id) {
        this.contact_id = contact_id;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof ETContact) {
            ETContact contact = (ETContact) object;
            return contact_id == this.contact_id && contact.user.getId().equals(this.user.getId());
        }
        return false;
    }
}
