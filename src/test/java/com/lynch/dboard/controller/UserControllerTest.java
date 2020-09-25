package com.lynch.dboard.controller;

import com.lynch.dboard.domain.User;
import com.lynch.dboard.repository.TagRepository;
import com.lynch.dboard.repository.UserRepository;
import com.lynch.dboard.service.AppUserDetailsService;
import com.lynch.dboard.service.TagService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private AppUserDetailsService userService;

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void authenticate() {
  }

  @Test
  void getUserByUsername() {
  }

  @Test
  void getUsers() {
  }

  @Test
  void getUser() {
  }

  @Test
  void createUser() {
  }

  @Test
  void updateUser() {
  }

  @Test
  void deleteUser() {
  }

  @Test
  void findAllUsernames() {
  }

  @Test
  void findAllEmails() {
  }
}
