package com.lynch.dboard.domain;

import java.util.Date;
import java.util.Set;

public interface DiscussionHeader {

  Long getId();
  String getDiscussTitle();
  Date getDiscussTimestamp();
  Set<Tag> getTags();
  String getContributor();
}
