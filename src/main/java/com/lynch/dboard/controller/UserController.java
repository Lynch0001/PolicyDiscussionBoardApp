package com.lynch.dboard.controller;

import com.lynch.dboard.domain.User;
import com.lynch.dboard.domain.UserDto;
import com.lynch.dboard.repository.UserRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  private final Logger log = LoggerFactory.getLogger(UserController.class);

  @PostMapping("users/authenticate")
  public ResponseEntity authenticate(@RequestBody String credentials){
    log.debug("Navigated to user controller authenticate Method");
    JSONObject jo = new JSONObject(credentials);
    String username = jo.getString("username");
    log.debug("Returning HttpStatus.OK for user: ", username);
    return ResponseEntity.ok(userRepository.findByUsername(username));
  }

  @GetMapping("/user")
  public User getUserByUsername(@RequestParam String username) {
    log.debug("Activated user controller getUser Method");
    User tempUser = userRepository.findByUsername(username);
    log.debug("Credentials from user controller getUser Method: ", tempUser);
    return tempUser;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    log.debug("Navigated to user controller getUsers Method");
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public Optional<User> getUser(@PathVariable Long id) {
    log.debug("Navigated to user controller authenticator");
    return userRepository.findById(id);
  }

  @PostMapping("/users/register")
  public void createUser(@RequestBody UserDto userDto) {
    log.debug("Creating User: ", userDto);
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    userRepository.save(user);
  }

  @PutMapping("/users")
  public void updateUser(@RequestBody UserDto userDto) {
    log.debug("Updating User: ", userDto);
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    userRepository.save(user);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Long id) {
    log.debug("Deleting User with ID: ", id);
    userRepository.deleteById(id);
  }


  // check if single user name is available "/users/{username}"

  @GetMapping("/users/usernames/all")
  public List<String> findAllUsernames(){
    return userRepository.findAllUsernames();
  }

  // check if single user email is registered "/users/{username}"

  @GetMapping("/users/useremails/all")
  public List<String> findAllEmails(){
    return userRepository.findAllEmails();
  }
}
