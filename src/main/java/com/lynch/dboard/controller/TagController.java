package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Tag;
import com.lynch.dboard.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * REST controller for managing {@link Tag}.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class TagController {

  private final Logger log = LoggerFactory.getLogger(TagController.class);

  private final TagService tagService;

  public TagController(TagService tagService) {
    this.tagService = tagService;
  }


  /**
   * {@code POST  /tags} : Create a new tag.
   *
   * @param tag the tag to create.
   */
  @PostMapping("/tags")
  public void createTag(@RequestBody Tag tag) {
    log.debug("REST request to save Tag : {}", tag);
    tagService.create(tag);
  }

  /**
   * {@code PUT  /tags} : Updates an existing tag.
   *
   * @param tag the tag to update.
   */
  @PutMapping("/tags")
  public void updateTag(@RequestBody Tag tag) {
    log.debug("REST request to update Tag : {}", tag);
    tagService.update(tag);
  }

  /**
   * {@code GET  /tags} : get all the tags.
   *
   * @param pageable the pagination information.
   */
  @GetMapping("/tags")
  public List<String> getAllTags() {
    log.debug("REST request to get a page of Tags");
    List<Tag> temp = tagService.findAll();
    return temp.stream().map(tag -> tag.getTag()).distinct().sorted().collect(Collectors.toList());
  }

  /**
   * {@code GET  /tags/:id} : get the "id" tag.
   *
   * @param id the id of the tag to retrieve.
   */
  @GetMapping("/tags/{id}")
  public Optional<Tag> getTag(@PathVariable Long id) {
    log.debug("REST request to get Tag : {}", id);
    return tagService.findById(id);
  }

  /**
   * {@code DELETE  /tags/:id} : delete the "id" tag.
   *
   * @param id the id of the tag to delete.
   */
  @DeleteMapping("/tags/{id}")
  public void deleteTag(@PathVariable Tag id) {
    log.debug("REST request to delete Tag : {}", id);
    tagService.delete(id);
  }
}


