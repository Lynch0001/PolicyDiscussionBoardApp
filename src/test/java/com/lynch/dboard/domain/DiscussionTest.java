package com.lynch.dboard.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscussionTest {

  Discussion discussion;

  /**
   * Build a Test Discussions.
   */
  @BeforeEach
  void setUp() {
    System.out.println("Test Class setup");
    Set<Tag> tags = new HashSet<>();
    tags.add(new Tag("TestTag1"));
    tags.add(new Tag("TestTag2"));
    Set<Comment> comments = new HashSet<>();
    comments.add(new Comment(new Date(), "TestComment1", "TestContributor1"));
    comments.add(new Comment(new Date(), "TestComment2", "TestContributor2"));
    discussion = new Discussion("TestTitle", "TestSubTitle", new Date(), "TestContent", tags, comments, "TestContributor");
  }

  @Test
  void newDiscussionNotNull() {
    assertAll(
            () -> assertThat(discussion.getDiscussTitle()).isNotNull(),
            () -> assertThat(discussion.getDiscussSubTitle()).isNotNull(),
            () -> assertThat(discussion.getDiscussTimestamp()).isNotNull(),
            () -> assertThat(discussion.getDiscussContent()).isNotNull(),
            () -> assertThat(discussion.getContributor()).isNotNull(),
            () -> assertThat(discussion.getTags()).isNotNull(),
            () -> assertThat(discussion.getComments()).isNotNull());
  }

  @Test
  void newDiscussionPropsSet() {
    assertAll(
            () -> assertEquals("TestTitle", discussion.getDiscussTitle(), "Discussion Title Failed"),
            () -> assertEquals("TestSubTitle", discussion.getDiscussSubTitle(), "Discussion SubTitle Failed"),
            () -> assertEquals("TestContent", discussion.getDiscussContent(), "Discussion Content Failed"),
            () -> assertEquals("TestContributor", discussion.getContributor(), "Discussion Contributor Failed"));
  }

  @Disabled
  @Test
  void newNullDiscussionTitleIsNull() {
    fail();                               // Test for Null input
  }

  @Test
  void newDiscussionTagsAdded() {
    Set<Tag> tags = discussion.getTags();
    assertAll(
            ()-> assertEquals(2, (discussion.getTags()).size()),
            ()-> assertTrue(tags.toString().contains("TestTag1")),
            ()-> assertTrue(tags.toString().contains("TestTag2")));
  }

  @Test
  void newDiscussionCommentsAdded() {
    Set<Comment> comments = discussion.getComments();
    assertAll(
            ()-> assertEquals(2, (discussion.getComments()).size()),
            ()-> assertTrue((comments.toString().contains("TestComment1"))),
            ()-> assertTrue((comments.toString().contains("TestComment2"))));
  }
}
