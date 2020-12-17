package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Message;
import com.lynch.dboard.service.AppUserDetailsService;
import com.lynch.dboard.service.CommentService;
import com.lynch.dboard.service.MessageService;
import com.lynch.dboard.transfer.MessageDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@WebMvcTest(controllers = MessageController.class)
class MessageControllerTest {

  private final static Long TEST_USER_ID = 1234L;
  private final static String TEST_USER_NAME = "test_name";
  private final static String TEST_USER_EMAIL = "test_email@mail.com";
  private final static String TEST_USER_MESSAGE = "test_message";

  private MessageDto testMessageDto1;
  private MessageDto testMessageDto2;



  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;


  @BeforeEach
  void setup(){
  }

  @Test
  void greetingMessage() throws Exception {
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "api/messageTest",String.class)).contains("Hello, World");
  }


  @Test
  void getMessage() {
    Long id = new Long(1l);
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "api/messages/{id}",Message.class, id)).hasFieldOrPropertyWithValue("name","Jane Doe");
  }


  @Test
  void getAllMessages() {
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "api/messages",List.class)).hasSizeBetween(1,10);
  }

  @Test
  void updateMessage() {
  }

  @Test
  void deleteMessage() {
  }
}
