package com.lynch.dboard.service;

import com.lynch.dboard.domain.Message;
import com.lynch.dboard.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
  private final MessageRepository messageRepository;

  private final Logger log = LoggerFactory.getLogger(MessageService.class);

  public MessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  /**
   * Save a message.
   *
   * @param message the entity to save.
   */
  public ResponseEntity<Message> save(Message message) throws NullPointerException{
    if(message.getName() == null || message.getName().isEmpty() || message.getEmail() == null || message.getEmail().isEmpty() || message.getMessage() == null || message.getMessage().isEmpty()){
      throw new NullPointerException("INPUT ERROR - Unexpected null inputs in submitted MESSAGE");
    }
    log.debug("Request to save Discussion : {}", message);
    Message response = messageRepository.save(message);
    return ResponseEntity.ok(response);
  }

  /**
   * Get all the messages.
   *
   * @param pageable the pagination information.
   */
  @Transactional(readOnly = true)
  public List<Message> findAll() {
    log.debug("Request to get all Messages");
    return messageRepository.findAll();
  }

  /**
   * Get one message by id.
   *
   * @param id the id of the entity.
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<Message> findOne(Long id) {
    log.debug("Request to get message : {}", id);
    return messageRepository.findById(id);
  }

  /**
   * Delete the discussion by id.
   *
   * @param id the id of the entity.
   */
  public void delete(Long id) {
    log.debug("Request to delete message : {}", id);
    messageRepository.deleteById(id);
  }
}

