package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Discussion;
import com.lynch.dboard.domain.Tag;
import com.lynch.dboard.service.DiscussionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


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
   * // @param pageable the pagination information.
   */
  @GetMapping("/discussions")
  public List<Discussion> getAllDiscussions() {
    log.debug("REST request to get a page of Discussions");
    return discussionService.findAll();
  }

  /**
   * {@code GET  /discussion/headers} : get all the discussion headers ONLY.
   *
   * // @param pageable the pagination information.
   */
  @GetMapping("/discussion/headers")
  public List<Discussion> getAllDiscussionHeaders() {
    log.debug("REST request to get a page of Discussion headers");
    return discussionService.findAllDiscussionHeaders();
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
   * {@code GET  /discussions/tag/:tag} : get discussions with "tag".
   *
   * @param tag is among tags in discussions to retrieve.
   */
  @GetMapping("/discussions/tag")
  public List<Discussion> getDiscussionsByTag(@RequestParam String tag) {
    log.debug("REST request to get Discussions with Tag : {}", tag);
    return discussionService.findAllDiscussionsByTag(tag);
  }

  @GetMapping("/discussions/contributor")
  public List<Discussion> getDiscussionsByContributor(@RequestParam String contributorName) {
    log.debug("REST request to get Discussions with Tag : {}", contributorName);
    List<Discussion> temp = discussionService.findAll();
    return temp.stream().filter(discussion -> discussion.getContributor().equals(contributorName)).collect(Collectors.toList());
  }

  /**
   * {@code DELETE  /discussions/:id} : delete the "id" discussion.
   *
   * @param id is id of the discussion to delete.
   */
  @DeleteMapping("/discussions/{id}")
  public void deleteDiscussion(@PathVariable Long id) {
    log.debug("REST request to delete Discussion : {}", id);
    discussionService.delete(id);
  }
}


