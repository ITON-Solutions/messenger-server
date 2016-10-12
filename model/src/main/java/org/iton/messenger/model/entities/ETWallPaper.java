/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iton.messenger.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "telegram_wallpapers")
public class ETWallPaper implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "location")
    private String location;

    public ETWallPaper() {
    }

    public ETWallPaper(Integer id, String location, int width, int height) {
        this.id       = id;
        this.location = location;
        this.width    = width;
        this.height   = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        if (this.width <= 100 && this.height <= 100) {
            return "s";
        } else if (this.width <= 320 && this.height <= 320) {
            return "m";
        } else if (this.width <= 800 && this.height <= 800) {
            return "x";
        } else if (this.width <= 1280 && this.height <= 1280) {
            return "y";
        } else {
            return "w";
        }
    }
}
