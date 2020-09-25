package com.lynch.dboard.controller;

import com.lynch.dboard.repository.CommentRepository;
import com.lynch.dboard.repository.TagRepository;
import com.lynch.dboard.service.CommentService;
import com.lynch.dboard.service.TagService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class TagControllerTest {

  @Mock
  private TagRepository tagRepository;

  @InjectMocks
  private TagService tagService;

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void createTag() {
  }

  @Test
  void updateTag() {
  }

  @Test
  void getAllTags() {
  }

  @Test
  void getAllTagNames() {
  }

  @Test
  void getTag() {
  }

  @Test
  void deleteTag() {
  }
}
