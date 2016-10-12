/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iton.messenger.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 *
 * @author root
 */
@Entity
@Table(name = "telegram_users", indexes={ @Index(name = "idx_phone", columnList="phone")})

public class ETUser implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username")
    private String username;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "status")
    private int status;

    @Column(name = "data")
    private byte[] data;

    @Column(name = "created")
    private Timestamp created;

    @OneToMany(mappedBy="user", cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
    private List<ETContact> contacts;

    public ETUser(){
    }

    public ETUser(Integer id,
                  String first_name,
                  String last_name,
                  String username,
                  String phone,
                  int status,
                  byte[] data)
    {
        this.id          = id;
        this.first_name  = first_name;
        this.last_name   = last_name;
        this.username    = username;
        this.phone       = phone;
        this.status      = status;
        this.data        = data;
        this.created = new Timestamp(System.currentTimeMillis());
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public List<ETContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<ETContact> contacts) {
        this.contacts = contacts;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
