package org.iton.messenger.api.messages;

import org.iton.messenger.api.MessageMedia;
import org.iton.messenger.api.contacts.TLContactsLink;

import org.iton.messenger.core.TLObject;
import org.iton.messenger.core.TLVector;

public abstract class SentMessage extends TLObject
{
    protected int id;
    protected int date;
    protected MessageMedia media;
    protected int pts;
    protected int pts_count;
    protected TLVector<TLContactsLink> links = new TLVector<>();
    protected int seq;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public MessageMedia getMedia() {
    return media;
  }

  public void setMedia(MessageMedia media) {
    this.media = media;
  }

  public int getPts() {
    return pts;
  }

  public void setPts(int pts) {
    this.pts = pts;
  }

  public int getPtsCount() {
    return pts_count;
  }

  public void setPtsCount(int pts_count) {
    this.pts_count = pts_count;
  }

  public TLVector<TLContactsLink> getLinks() {
    return links;
  }

  public void setLinks(TLVector<TLContactsLink> links) {
    this.links = links;
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }
}