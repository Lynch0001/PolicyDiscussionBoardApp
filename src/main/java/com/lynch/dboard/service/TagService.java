package com.lynch.dboard.service;

import com.lynch.dboard.domain.Comment;
import com.lynch.dboard.domain.Tag;
import com.lynch.dboard.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Tag}.
 */
@Service
public class TagService {

  @Autowired
  private TagRepository tagRepository;

  /**
   * Get all tags.
   *
   * @return list of all tags.
   */
  public List<Tag> findAll(){
    return tagRepository.findAll();
  }

  /**
   * Get tag with id.
   *
   * @param id the tag.
   * @return tag with specified id.
   */
  public Optional<Tag> findById(Long id){
    return tagRepository.findById(id);
  }

  /**
   * Save a tag.
   *
   * @param tag to create.
   */
  public void create(Tag tag){
    tagRepository.save(tag);
  }

  /**
   * Save a discussion.
   *
   * @param tag to update.
   */
    public void update(Tag tag){
    tagRepository.save(tag);
  }

  /**
   * Delete tag with id.
   *
   * @param tag to delete.
   */
  public void delete(Tag tag){
    tagRepository.delete(tag);
  }
}
