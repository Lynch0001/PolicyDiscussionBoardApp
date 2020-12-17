package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Comment;
import com.lynch.dboard.domain.Message;
import com.lynch.dboard.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentControllerTest {


  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;


  @Test
  void getComment() {
    Long id = 1l;
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "api/comments/{id}", Comment.class, id)).hasFieldOrPropertyWithValue("id",1L);
  }

}
