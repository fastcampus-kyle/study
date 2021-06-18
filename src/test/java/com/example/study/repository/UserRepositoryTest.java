package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends StudyApplicationTests {

  // Dependency Injection (DI)
  @Autowired
  private UserRepository userRepository;

  @Test
  public void create() {
    User user = new User();
    user.setAccount("TestUser03");
    user.setPassword("1234");
    user.setStatus("status");
    user.setEmail("TestUser01@gmail.com");
    user.setPhoneNumber("010-111-3333");
    user.setCreatedAt(LocalDateTime.now());
    user.setCreatedBy("TestUser3");

    User newUser = userRepository.save(user);
    System.out.println("newUser : " + newUser);
  }

  @Test
  @Transactional
  public void read() {
    Optional<User> user = userRepository.findByAccount("TestUser03");

    user.ifPresent(selectUser -> {
      selectUser.getOrderDetailList().stream().forEach(detail ->{
        System.out.println(detail.getItem());
      });
    });
  }

  @Test
  public void update() {
    Optional<User> user = userRepository.findById(4L);

    user.ifPresent(selectUser -> {
      selectUser.setAccount("pppp");
      selectUser.setUpdatedAt(LocalDateTime.now());
      selectUser.setUpdatedBy("update method()");

      userRepository.save(selectUser);
    });

  }

  @Test
  @Transactional
  public void delete() {
    Optional<User> user = userRepository.findById(4L);

    Assertions.assertTrue(user.isPresent()); // false

    user.ifPresent(selectUser -> {
      userRepository.delete(selectUser);
    });

    Optional<User> deleteUser = userRepository.findById(2L);

    Assertions.assertFalse(deleteUser.isPresent()); // false

  }
}
