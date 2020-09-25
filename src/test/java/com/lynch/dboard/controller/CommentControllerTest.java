package com.lynch.dboard.controller;

import com.lynch.dboard.repository.CommentRepository;
import com.lynch.dboard.repository.MessageRepository;
import com.lynch.dboard.service.CommentService;
import com.lynch.dboard.service.MessageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CommentControllerTest {

  @Mock
  private CommentRepository commentRepository;

  @InjectMocks
  private CommentService commentService;

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void createComment() {
  }

  @Test
  void updateComment() {
  }

  @Test
  void getAllComments() {
  }

  @Test
  void getComment() {
  }

  @Test
  void deleteComment() {
  }
}
