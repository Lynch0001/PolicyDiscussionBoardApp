package com.lynch.dboard.service;

import com.lynch.dboard.domain.Tag;
import com.lynch.dboard.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

  @Autowired
  private TagRepository tagRepository;

  public List<Tag> findAll(){
    return tagRepository.findAll();
  }

  public Optional<Tag> findById(Long id){
    return tagRepository.findById(id);
  }

  public void create(Tag tag){
    tagRepository.save(tag);
  }

  public void update(Tag tag){
    tagRepository.save(tag);
  }

  public void delete(Tag tag){
    tagRepository.delete(tag);
  }
}
