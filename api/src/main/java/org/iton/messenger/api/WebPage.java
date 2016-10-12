package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class WebPage extends TLObject
{
    protected long id;
    protected int date;
    protected int flags;
    protected String url;
    protected String display_url;
    protected String type;
    protected String site_name;
    protected String title;
    protected String description;
    protected Photo photo;
    protected String embed_url;
    protected String embed_type;
    protected int embed_width;
    protected int embed_height;
    protected int duration;
    protected String author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisplayUrl() {
        return display_url;
    }

    public void setDisplayUrl(String display_url) {
        this.display_url = display_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSiteName() {
        return site_name;
    }

    public void setSiteName(String site_name) {
        this.site_name = site_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getEmbedUrl() {
        return embed_url;
    }

    public void setEmbedUrl(String embed_url) {
        this.embed_url = embed_url;
    }

    public String getEmbedType() {
        return embed_type;
    }

    public void setEmbedType(String embed_type) {
        this.embed_type = embed_type;
    }

    public int getEmbedWidth() {
        return embed_width;
    }

    public void setEmbedWidth(int embed_width) {
        this.embed_width = embed_width;
    }

    public int getEmbedHeight() {
        return embed_height;
    }

    public void setEmbedHeight(int embed_height) {
        this.embed_height = embed_height;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
