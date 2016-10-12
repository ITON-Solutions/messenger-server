/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iton.messenger.model.entities;


import javax.persistence.*;
import javax.persistence.Index;
;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "telegram_keys", indexes={ @Index(name = "idx_user", columnList="user")})
public class ETAuthorization implements Serializable
{
    @Id
    @Column(name = "key_id")
    private String key_id;

    @Column(name = "dh_key", nullable = false)
    private byte[] dh_key;

    @Column(name = "created")
    private Timestamp created;

    @OneToOne(targetEntity=ETUser.class, cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private ETUser user;

    public ETAuthorization()
    {
    }

    public ETAuthorization(String key_id, byte[] dh_key, ETUser user)
    {
        this.key_id  = key_id;
        this.dh_key  = dh_key;
        this.created = new Timestamp(System.currentTimeMillis());
        this.user    = user;
    }


    public String getKeyId() {
        return key_id;
    }

    public void setKeyId(String key_id) {
        this.key_id = key_id;
    }

    public byte[] getDHKey() {
        return dh_key;
    }

    public void setDHKey(byte[] dh_key) {
        this.dh_key = dh_key;
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
}
