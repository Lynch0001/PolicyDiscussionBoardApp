package com.lynch.dboard.controller;

import com.lynch.dboard.domain.Comment;
import com.lynch.dboard.transfer.CommentDto;
import com.lynch.dboard.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;

  /**
   * REST controller for managing {@link Comment}.
   */
  @CrossOrigin(origins = "http://localhost:4200")
  @RestController
  @RequestMapping("/api")
  public class CommentController {

    private final Logger log = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
      this.commentService = commentService;
    }

    /**
     * {@code POST  /comments} : Create a new comment.
     *
     * @param commentDto the comment to create.
     */
    @PostMapping("/comments")
    public void createComment(@RequestBody CommentDto commentDto) {
      log.debug("REST request to save Comment : {}", commentDto);
      Comment comment = new Comment();
      BeanUtils.copyProperties(commentDto, comment);
      commentService.save(comment);
    }

    /**
     * {@code PUT  /comments} : Updates an existing comment.
     *
     * @param commentDto the comment to update.
     */
    @PutMapping("/comments")
    public void updateComment(@RequestBody CommentDto commentDto) {
      log.debug("REST request to update Comment : {}", commentDto);
      Comment comment = new Comment();
      BeanUtils.copyProperties(commentDto, comment);
      commentService.save(comment);
    }

    /**
     * {@code GET  /comments} : get all the comments.
     *
     * @param pageable the pagination information.
     */
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
      log.debug("REST request to get a page of Comments");
      return commentService.findAll();
    }

    /**
     * {@code GET  /comments/:id} : get the "id" comment.
     *
     * @param id the id of the comment to retrieve.
     */
    @GetMapping("/comments/{id}")
    public Optional<Comment> getComment(@PathVariable Long id) {
      log.debug("REST request to get Comment : {}", id);
      return commentService.findOne(id);
    }

    /**
     * {@code DELETE  /comments/:id} : delete the "id" comment.
     *
     * @param id the id of the comment to delete.
     */
    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
      log.debug("REST request to delete Comment : {}", id);
      commentService.delete(id);
    }
  }

