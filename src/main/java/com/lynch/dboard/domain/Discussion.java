package com.lynch.dboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A Discussion.
 */
@Entity
@Table(name = "discussion")
public class Discussion implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "discuss_title")
  private String discussTitle;

  @Column(name = "discuss_subtitle")
  private String discussSubTitle;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  @Column(name = "discuss_timestamp")
  private Date discussTimestamp;

  @Lob
  @Column(name = "discuss_content", nullable = false)
  private String discussContent;

  @OneToMany(targetEntity=Tag.class,cascade = CascadeType.ALL,
          fetch = FetchType.LAZY, orphanRemoval = true)
  private Set<Tag> tags = new HashSet<>();

  @OneToMany(targetEntity=Comment.class,cascade = CascadeType.ALL,
          fetch = FetchType.LAZY, orphanRemoval = true)
  private Set<Comment> comments = new HashSet<>();

  private String contributor;

  public Discussion() {
  }

  public Discussion(String discussTitle, String discussSubTitle, Date discussTimestamp, String discussContent, Set<Tag> tags, Set<Comment> comments, String contributor) {
    this.discussTitle = discussTitle;
    this.discussSubTitle = discussSubTitle;
    this.discussTimestamp = discussTimestamp;
    this.discussContent = discussContent;
    this.tags = tags;
    this.comments = comments;
    this.contributor = contributor;
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

  public String getDiscussSubTitle() {
    return discussSubTitle;
  }

  public void setDiscussSubTitle(String discussSubTitle) {
    this.discussSubTitle = discussSubTitle;
  }


  @Override
  public String toString() {
    return "Discussion{" +
            "id=" + id +
            ", discussTitle='" + discussTitle + '\'' +
            ", discussSubTitle='" + discussSubTitle + '\'' +
            ", discussTimestamp=" + discussTimestamp +
            ", discussContent='" + discussContent + '\'' +
            ", tags=" + tags +
            '}';
  }
}
