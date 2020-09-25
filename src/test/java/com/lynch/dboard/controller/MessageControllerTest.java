package com.lynch.dboard.controller;

import com.lynch.dboard.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageController.class)
class MessageControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void greetingMessage() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("/messageTest");
    MvcResult result = mockMvc.perform(request).andReturn();
    assertEquals("Hello, World", result.getResponse().getContentAsString());
  }

  @Test
  void createMessage() throws Exception {


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
