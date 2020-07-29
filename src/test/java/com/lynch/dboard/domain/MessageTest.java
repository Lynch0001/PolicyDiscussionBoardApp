package com.lynch.dboard.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MessageTest {

  @Test
  void newMessageHasTimestamp() {
    Message message = new Message("John Doe", "JDoe@mail.net", "Content");
    assertThat(message.getMessageTimestamp()).isNotNull();
  }

  @Test
  void newMessageIsReadSetToFalse() {
    Message message = new Message("John Doe", "JDoe@mail.net", "Content");
    assertThat(message.getRead()).isFalse();
  }
}
