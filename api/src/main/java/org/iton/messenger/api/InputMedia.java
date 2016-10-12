package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class InputMedia extends TLObject
{
    protected String phone_number;
    protected String first_name;
    protected String last_name;
    protected InputFile file;
    protected InputFile thumb;
    protected String mime_type;
    protected TLVector<DocumentAttribute> attributes = new TLVector<>();
    protected InputGeoPoint geo_point;
    protected InputAudio audio;
    protected InputVideo video;
    protected InputPhoto photo;
    protected InputDocument document;
    protected int duration;
    protected int width;
    protected int height;

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
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

    public InputFile getFile() {
        return file;
    }

    public void setFile(InputFile file) {
        this.file = file;
    }

    public InputFile getThumb() {
        return thumb;
    }

    public void setThumb(InputFile thumb) {
        this.thumb = thumb;
    }

    public String getMimeType() {
        return mime_type;
    }

    public void setMimeType(String mime_type) {
        this.mime_type = mime_type;
    }

    public TLVector<DocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<DocumentAttribute> attributes) {
        this.attributes = attributes;
    }

    public InputGeoPoint getGeoPoint() {
        return geo_point;
    }

    public void setGeoPoint(InputGeoPoint geo_point) {
        this.geo_point = geo_point;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public InputAudio getAudio() {
        return audio;
    }

    public void setAudio(InputAudio audio) {
        this.audio = audio;
    }

    public InputVideo getVideo() {
        return video;
    }

    public void setVideo(InputVideo video) {
        this.video = video;
    }

    public InputPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(InputPhoto photo) {
        this.photo = photo;
    }

    public InputDocument getDocument() {
        return document;
    }

    public void setDocument(InputDocument document) {
        this.document = document;
    }
}
