package com.lynch.dboard.service;

import com.lynch.dboard.domain.User;
import com.lynch.dboard.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

  private final Logger log = LoggerFactory.getLogger(AppUserDetailsService.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.debug("Activating loadByUsername in AppUserDetailsService");
    User user = userRepository.findByUsername(username);
    log.debug("loadByUsername found user: ", user);
    UserDetails foundDetails = new CurrentUserDetails(user);
    log.debug("loadByUsername found userDetails: ", foundDetails);
    return foundDetails;
  }
}
