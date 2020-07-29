package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Discussion;
import com.lynch.dboard.service.DiscussionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * REST controller for managing {@link Discussion}.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class DiscussionController {

  private final Logger log = LoggerFactory.getLogger(DiscussionController.class);

  private final DiscussionService discussionService;

  public DiscussionController(DiscussionService discussionService) {
    this.discussionService = discussionService;
  }


  /**
   * {@code POST  /discussions} : Create a new discussion.
   *
   * @param discussion the discussion to create.
   */
  @PostMapping("/discussions")
  public void createDiscussion(@RequestBody Discussion discussion) {
    log.debug("REST request to save Discussion : {}", discussion);
    discussionService.save(discussion);
  }

  /**
   * {@code PUT  /discussions} : Updates an existing discussion.
   *
   * @param discussion the discussion to update.
   */
  @PutMapping("/discussions")
  public void updateDiscussion(@RequestBody Discussion discussion) {
    log.debug("REST request to update Discussion : {}", discussion);
    discussionService.save(discussion);
  }

  /**
   * {@code GET  /discussions} : get all the discussions.
   *
   * @param pageable the pagination information.
   */
  @GetMapping("/discussions")
  public List<Discussion> getAllDiscussions() {
    log.debug("REST request to get a page of Discussions");
    return discussionService.findAll();
  }

  /**
   * {@code GET  /discussions/:id} : get the "id" discussion.
   *
   * @param id the id of the discussion to retrieve.
   */
  @GetMapping("/discussions/{id}")
  public Optional<Discussion> getDiscussion(@PathVariable Long id) {
    log.debug("REST request to get Discussion : {}", id);
    return discussionService.findOne(id);
  }

  /**
   * {@code DELETE  /discussions/:id} : delete the "id" discussion.
   *
   * @param id the id of the discussion to delete.
   */
  @DeleteMapping("/discussions/{id}")
  public void deleteDiscussion(@PathVariable Long id) {
    log.debug("REST request to delete Discussion : {}", id);
    discussionService.delete(id);
  }
}


