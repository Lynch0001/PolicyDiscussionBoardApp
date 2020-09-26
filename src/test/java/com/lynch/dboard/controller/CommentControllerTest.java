package com.lynch.dboard.controller;

import com.lynch.dboard.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CommentController.class)
class CommentControllerTest {


  private MockMvc mockMvc;

  @Mock
  private CommentService commentService;

  @InjectMocks
  private CommentController commentController;


  @Test
  void getComment() {
  }
}
