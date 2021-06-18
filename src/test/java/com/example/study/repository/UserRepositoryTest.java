package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends StudyApplicationTests {

  // Dependency Injection (DI)
  @Autowired
  private UserRepository userRepository;

  @Test
  public void create() {
    String account = "Test01";
    String password = "Test01";
    String status = "REGISTERED";
    String email = "Test01@gmail.com";
    String phoneNumber = "010-1111-2222";
    LocalDateTime registeredAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "AdminServer";

    User user = new User();
    user.setAccount(account);
    user.setPassword(password);
    user.setStatus(status);
    user.setEmail(email);
    user.setPhoneNumber(phoneNumber);
    user.setRegisteredAt(registeredAt);
    user.setCreatedAt(createdAt);
    user.setCreatedBy(createdBy);

    User newUser = userRepository.save(user);

    Assert.assertNotNull(newUser);
  }

  @Test
  @Transactional
  public void read() {
    User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2221");
    Assert.assertNotNull(user);
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
