package com.lynch.dboard.domain;

import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private Date commentTimeStamp;
  private String commentContent;
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

  public Date getCommentTimeStamp() {
    return commentTimeStamp;
  }

  public void setCommentTimeStamp(Date commentTimeStamp) {
    this.commentTimeStamp = commentTimeStamp;
  }

  public String getCommentContent() {
    return commentContent;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }

  public String getContributor() {
    return contributor;
  }

  public void setContributor(String contributor) {
    this.contributor = contributor;
  }
}
