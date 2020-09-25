package com.lynch.dboard.controller;

import com.lynch.dboard.repository.CommentRepository;
import com.lynch.dboard.repository.DiscussionRepository;
import com.lynch.dboard.service.CommentService;
import com.lynch.dboard.service.DiscussionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class DiscussionControllerTest {

  @Mock
  private DiscussionRepository discussionRepository;

  @InjectMocks
  private DiscussionService discussionService;


  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void createDiscussion() {
  }

  @Test
  void updateDiscussion() {
  }

  @Test
  void getAllDiscussions() {
  }

  @Test
  void getAllDiscussionHeaders() {
  }

  @Test
  void getDiscussion() {
  }

  @Test
  void getDiscussionsByTag() {
  }

  @Test
  void getDiscussionsByContributor() {
  }

  @Test
  void deleteDiscussion() {
  }
}
