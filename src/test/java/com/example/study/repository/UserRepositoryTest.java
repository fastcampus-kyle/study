package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends StudyApplicationTests {

  // Dependency Injection (DI)
  @Autowired
  private UserRepository userRepository;

  @Test
  public void create() {
    User user = new User();
    user.setAccount("TestUser03");
    user.setEmail("TestUser01@gmail.com");
    user.setPhoneNumber("010-111-3333");
    user.setCreatedAt(LocalDateTime.now());
    user.setCreatedBy("TestUser3");

    User newUser = userRepository.save(user);
    System.out.println("newUser : " + newUser);
  }

  public void read() {

  }

  public void update() {

  }

  public void delete() {
  }
}
