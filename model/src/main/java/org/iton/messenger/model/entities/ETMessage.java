/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iton.messenger.model.entities;



import javax.persistence.*;
import java.io.Serializable;


/**
 *
 * @author root
 */
@Entity
@Table(name = "telegram_messages", indexes={ @Index(name = "idx_user_id", columnList="user_id"),
                                             @Index(name = "idx_from_id", columnList="from_id"),})

public class ETMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "from_id")
    private Integer from_id;

    @Column(name = "random_id", unique = true)
    private Long random_id;

    @Column(name = "read_state")
    private Integer read_state;

    @Column(name = "send_state")
    private Integer send_state;

    @Column(name = "data")
    private byte[] data;

    @Column(name = "is_out")
    private Integer out;

    @Column(name = "ttl")
    private Integer ttl;

    @Column(name = "media")
    private Integer media;

    @Column(name = "date")
    private Integer date;

    @Column(name = "reply_data")
    private byte[] reply_data;

    public ETMessage() {
    }

    public ETMessage(Integer user_id,
                     Integer from_id,
                     Integer read_state,
                     Integer send_state,
                     byte[] data,
                     Integer out,
                     Integer ttl,
                     Integer media,
                     Integer date,
                     byte[] reply_data)
    {
        this.user_id    = user_id;
        this.from_id    = from_id;
        this.read_state = read_state;
        this.send_state = send_state;
        this.data       = data;
        this.out        = out;
        this.ttl        = ttl;
        this.media      = media;
        this.date       = date;
        this.reply_data = reply_data;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getReadState() {
        return read_state;
    }

    public void setReadState(Integer read_state) {
        this.read_state = read_state;
    }

    public Integer getSendState() {
        return send_state;
    }

    public void setSendState(Integer send_state) {
        this.send_state = send_state;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getTTL() {
        return ttl;
    }

    public void setTTL(Integer ttl) {
        this.ttl = ttl;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = media;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public byte[] getReplyData() {
        return reply_data;
    }

    public void setReplyData(byte[] reply_data) {
        this.reply_data = reply_data;
    }

    public Long getRandomId() {
        return random_id;
    }

    public void setRandomId(Long random_id) {
        this.random_id = random_id;
    }

    public Integer getFromId() {
        return from_id;
    }

    public void setFromId(Integer from_id) {
        this.from_id = from_id;
    }
}
