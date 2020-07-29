package com.lynch.dboard.service;

import com.lynch.dboard.domain.User;
import com.lynch.dboard.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

public class CurrentUserDetails implements UserDetails {

  private final Logger log = LoggerFactory.getLogger(CurrentUserDetails.class);
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private UserRepository userRepository;

  private String username;
  private String password;
  private String lastName;
  private String firstName;
  private String email;
  private Date dateActivated;
  private Date lastLogin;
  private List<GrantedAuthority> authorities;


  public CurrentUserDetails(User user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.lastName = user.getLastName();
    this.firstName = user.getFirstName();
    this.email = user.getEmail();
    this.dateActivated = user.getDateActivated();
    this.lastLogin = user.getLastLogin();
    this.authorities = Arrays.stream(user.getRoles().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
