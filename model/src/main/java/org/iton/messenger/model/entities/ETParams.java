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
@Table(name = "telegram_params", indexes={ @Index(name = "idx_user_id", columnList="user_id")})

public class ETParams implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "pts")
    private Integer pts;


    @Column(name = "date")
    private Integer date;


    public ETParams() {
    }

    public ETParams(Integer user_id,
                    Integer pts,
                    Integer date)
    {
        this.user_id = user_id;
        this.pts     = pts;
        this.date    = date;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPts() {
        return pts;
    }

    public void setPts(Integer pts) {
        this.pts = pts;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
