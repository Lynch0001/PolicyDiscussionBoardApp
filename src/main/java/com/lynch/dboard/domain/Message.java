package com.lynch.dboard.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="messages")
public class Message implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "name")
  private String name;

  @Email
  @NotNull
  @Column(name = "email")
  private String email;

  @NotNull
  @Lob
  @Column(name = "message_content")
  private String message;
  @Column(name = "message_timestamp")
  private Date messageTimestamp = new Date();
  @Column(name = "message_is_read")
  private Boolean read = false;

  public Message(){};

  public Message(String name, String email, String message) {
    this.name = name;
    this.email = email;
    this.message = message;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Message message1 = (Message) o;
    return name.equals(message1.name) &&
            email.equals(message1.email) &&
            message.equals(message1.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, message);
  }

  @Override
  public String toString() {
    return "Message{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", message='" + message + '\'' +
            ", messageTimestamp='" + messageTimestamp + '\'' +
            '}';
  }
}
