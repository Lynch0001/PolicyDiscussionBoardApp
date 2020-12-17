package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Comment;
import com.lynch.dboard.domain.Message;
import com.lynch.dboard.service.AppUserDetailsService;
import com.lynch.dboard.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = CommentController.class)
class CommentControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @MockBean
  private CommentService commentService;

  @MockBean
  private AppUserDetailsService appUserDetailsService;

  @WithMockUser
  @Test
  void getComment() {
    Long id = 1l;
    assertThat(this.restTemplate.getForObject("http://localhost:8080/api/comments/{id}", Comment.class, id)).hasFieldOrPropertyWithValue("id",1L);
  }

}
