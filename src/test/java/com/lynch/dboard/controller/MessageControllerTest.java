package com.lynch.dboard.controller;

import com.lynch.dboard.repository.MessageRepository;
import com.lynch.dboard.service.MessageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class MessageControllerTest {

  @Mock
  private MessageRepository messageRepository;

  @InjectMocks
  private MessageService messageService;

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void greetingMessage() {
  }

  @Test
  void createMessage() {
  }

  @Test
  void updateMessage() {
  }

  @Test
  void getAllMessages() {
  }

  @Test
  void getMessage() {
  }

  @Test
  void deleteMessage() {
  }
}
