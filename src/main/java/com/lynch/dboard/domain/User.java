package com.lynch.dboard.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * A user.
 */
@Entity
@Table(name="user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //@NotNull
  //@Pattern(regexp = Constants.LOGIN_REGEX)
  //@Size(min = 1, max = 50)
  @Column(name="username")
  private String username;

  //@JsonIgnore
  // @NotNull
  //@Size(min = 60, max = 60)
  @Column(name = "password_hash", length = 60, nullable = false)
  private String password;


  @Column(name = "first_name", length = 50)
  private String firstName;


  @Column(name = "last_name", length = 50)
  private String lastName;

  @Column(length = 254, unique = true)
  private String email;

  private Date dateActivated = new Date();

  private Date lastLogin = new Date();

  private String roles = "ROLE_USER";

  public User(){}

  public User(String username, String password, String firstName, String lastName, String email){
    this.username = username;
    this.password = getHashedPassword(password);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateActivated = new Date();
    this.lastLogin = new Date();
    this.roles = "ROLE_USER";
  }

  /*
  public User(String username, @Size(min = 60, max = 60) String password, String firstName, String lastName, String email) {
    this.username = username;
    this.password = getHashedPassword(password);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateActivated = new Date();
    this.lastLogin = new Date();
    this.roles = "ROLE_USER";
  }
*/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String hPassword = bCryptPasswordEncoder.encode(password);
    this.password = hPassword;
  }

  public String getHashedPassword(String password) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String hPassword = bCryptPasswordEncoder.encode(password);
    return hPassword;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateActivated() {
    return dateActivated;
  }

  public void setDateActivated(Date userActivated) {
    this.dateActivated = userActivated;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(username, user.username) &&
            Objects.equals(password, user.password) &&
            Objects.equals(firstName, user.firstName) &&
            Objects.equals(lastName, user.lastName) &&
            Objects.equals(email, user.email) &&
            Objects.equals(dateActivated, user.dateActivated) &&
            Objects.equals(lastLogin, user.lastLogin) &&
            Objects.equals(roles, user.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, firstName, lastName, email, dateActivated, lastLogin, roles);
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", dateActivated=" + dateActivated +
            '}';
  }

}
