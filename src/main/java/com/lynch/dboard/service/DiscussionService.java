package com.lynch.dboard.service;

import com.lynch.dboard.domain.Comment;
import com.lynch.dboard.domain.Discussion;
import com.lynch.dboard.domain.DiscussionHeader;
import com.lynch.dboard.domain.Tag;
import com.lynch.dboard.repository.DiscussionRepository;
import com.lynch.dboard.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Discussion}.
 */
@Service
public class DiscussionService {

  private final DiscussionRepository discussionRepository;

  private final TagRepository tagRepository;

  private final Logger log = LoggerFactory.getLogger(DiscussionService.class);

  public DiscussionService(DiscussionRepository discussionRepository, TagRepository tagRepository) {
    this.discussionRepository = discussionRepository;
    this.tagRepository = tagRepository;
  }

  /**
   * Save a discussion.
   *
   * @param discussion the entity to save.
   */
  public void save(Discussion discussion) {
    log.debug("Request to save Discussion : {}", discussion);
    discussionRepository.save(discussion);
  }

  /**
   * Get all the discussions.
   *
   * @return list of all discussions.
   */
  @Transactional(readOnly = true)
  public List<Discussion> findAll() {
    log.debug("Request to get all Discussions");
    return discussionRepository.findAll();
  }

  /**
   * Get all the discussions headers.
   *
   * @return list of all discussions.
   */
  @Transactional(readOnly = true)
  public List<Discussion> findAllDiscussionHeaders() {
    log.debug("Request to get all Discussion Headers");
    return discussionRepository.findAll();
  }

  /**
   * Get all the discussions with specified tag.
   *
   * @param tag for discussions.
   * @return list of all discussions with specified tag.
   */
  @Transactional(readOnly = true)
  public List<Discussion> findAllDiscussionsByTag(String tag) {
    log.debug("Request to get all Discussions by Tag");
    Tag requestedTag = tagRepository.getTagByTag(tag);
    return discussionRepository.getAllByTagsContaining(requestedTag);
  }

  /**
   * Get one discussion by id.
   *
   * @param id of the discussion.
   * @return discussion with specified id.
   */
  @Transactional(readOnly = true)
  public Optional<Discussion> findOne(Long id) {
    log.debug("Request to get Discussion : {}", id);
    return discussionRepository.findById(id);
  }

  /**
   * Delete the discussion by id.
   *
   * @param id of the discussion.
   */
  public void delete(Long id) {
    log.debug("Request to delete Discussion : {}", id);
    discussionRepository.deleteById(id);
  }
}
