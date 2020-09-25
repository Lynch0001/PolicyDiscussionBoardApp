package com.lynch.dboard.transfer;

import java.io.Serializable;
import java.util.Date;

public class MessageDto implements Serializable {

  private Long id;
  private String name;
  private String email;
  private String message;
  private Date messageTimestamp = new Date();
  private Boolean read = false;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getMessageTimestamp() {
    return messageTimestamp;
  }

  public void setMessageTimestamp(Date messageTimestamp) {
    this.messageTimestamp = messageTimestamp;
  }

  public Boolean getRead() {
    return read;
  }

  public void setRead(Boolean read) {
    this.read = read;
  }
}
