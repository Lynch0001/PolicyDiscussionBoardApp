package com.lynch.dboard.domain;

import java.io.Serializable;

public class TagDto implements Serializable {

  private Long id;
  private String tag;

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
}
