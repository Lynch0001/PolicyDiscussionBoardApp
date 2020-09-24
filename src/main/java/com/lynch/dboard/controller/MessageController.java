package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Message;
import com.lynch.dboard.domain.MessageDto;
import com.lynch.dboard.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MessageController {

  private final Logger log = LoggerFactory.getLogger(MessageController.class);

  private final MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping("/messageTest")
  public String greetingMessage() {
    return "Hello, World";
  }


  /**
   * {@code POST  /messages} : Create a new message.
   *
   * @param messageDto the message to create.
   */
  @PostMapping("/messages/send")
  public void createMessage(@RequestBody MessageDto messageDto) {
    log.debug("REST request to save Message : {}", messageDto);
    Message message = new Message();
    BeanUtils.copyProperties(messageDto, message);
    messageService.save(message);
  }

  /**
   * {@code PUT  /messages} : Updates an existing message.
   *
   * @param messageDto the message to update.
   */
  @PutMapping("/messages")
  public void updateMessage(@RequestBody MessageDto messageDto) {
    log.debug("REST request to update Message : {}", messageDto);
    Message message = new Message();
    BeanUtils.copyProperties(messageDto, message);
    messageService.save(message);
  }

  /**
   * {@code GET  /messages} : get all the messages.
   *
   * @param pageable the pagination information.
   */
  @GetMapping("/messages")
  public List<Message> getAllMessages() {
    log.debug("REST request to get a page of Messages");
    return messageService.findAll();
  }

  /**
   * {@code GET  /messages/:id} : get the "id" message.
   *
   * @param id the id of the message to retrieve.
   */
  @GetMapping("/messages/{id}")
  public Optional<Message> getMessage(@PathVariable Long id) {
    log.debug("REST request to get Message : {}", id);
    return messageService.findOne(id);
  }

  /**
   * {@code DELETE  /messages/:id} : delete the "id" message.
   *
   * @param id the id of the message to delete.
   */
  @DeleteMapping("/messages/{id}")
  public void deleteMessage(@PathVariable Long id) {
    log.debug("REST request to delete Message : {}", id);
    messageService.delete(id);
  }
}
