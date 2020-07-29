package com.lynch.dboard.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Tag.
 */
@Entity
@Table(name="tags")
public class Tag implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="tag")
  private String tag;

  public Tag(){
  }

  public Tag(String tag){
    this.tag = tag;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }


  @Override
  public String toString() {
    return "Tag{" +
            "id=" + id +
            ", tag='" + tag + '\'' +
            '}';
  }
}
