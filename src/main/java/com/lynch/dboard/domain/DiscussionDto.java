package com.lynch.dboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DiscussionDto implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private String discussTitle;
  private String discussSubTitle;
  private Date discussTimestamp;
  private String discussContent;
  private Set<Tag> tags = new HashSet<>();
  private Set<Comment> comments = new HashSet<>();
  private String contributor;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDiscussTitle() {
    return discussTitle;
  }

  public void setDiscussTitle(String discussTitle) {
    this.discussTitle = discussTitle;
  }

  public String getDiscussSubTitle() {
    return discussSubTitle;
  }

  public void setDiscussSubTitle(String discussSubTitle) {
    this.discussSubTitle = discussSubTitle;
  }

  public Date getDiscussTimestamp() {
    return discussTimestamp;
  }

  public void setDiscussTimestamp(Date discussTimestamp) {
    this.discussTimestamp = discussTimestamp;
  }

  public String getDiscussContent() {
    return discussContent;
  }

  public void setDiscussContent(String discussContent) {
    this.discussContent = discussContent;
  }

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  public void setComments(Set<Comment> comments) {
    this.comments = comments;
  }

  public String getContributor() {
    return contributor;
  }

  public void setContributor(String contributor) {
    this.contributor = contributor;
  }
}
