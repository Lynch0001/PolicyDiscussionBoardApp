package com.lynch.dboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * A Comment.
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  @Column(name = "comment_timestamp")
  private Date commentTimeStamp;

  @Column(name = "comment_content", nullable = false)
  private String commentContent;

  private String contributor;

  public Comment() {
  }

  public Comment(Date commentTimeStamp, String commentContent, String contributor) {
    this.commentTimeStamp = commentTimeStamp;
    this.commentContent = commentContent;
    this.contributor = contributor;
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

  public Comment commentContent(String commentContent) {
    this.commentContent = commentContent;
    return this;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }


  public String getContributor() {
    return contributor;
  }

  public Comment contributor(String contributor) {
    this.contributor = contributor;
    return this;
  }

  public void setContributor(String contributor) {
    this.contributor = contributor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Comment)) {
      return false;
    }
    return id != null && id.equals(((Comment) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "Comment{" +
            "id=" + getId() +
            ", commentTimeStamp='" + getCommentTimeStamp() + "'" +
            ", commentContent='" + getCommentContent() + "'" +
            "}";
  }

}
