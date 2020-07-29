package com.lynch.dboard.config;

import com.lynch.dboard.domain.User;
import com.lynch.dboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="app.db.init", havingValue = "true")
public class DbInit implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... strings) throws Exception{

    this.userRepository.deleteAll();

    User user1 = new User("user", "password", "Jane", "Doe", "Jane.Doe@Mail.com");
    this.userRepository.save(user1);

    User user2 = new User("admin", "password", "John", "Doe", "John.Doe@Mail.com");
    user2.setRoles("ROLE_ADMIN");
    this.userRepository.save(user2);
}
}
