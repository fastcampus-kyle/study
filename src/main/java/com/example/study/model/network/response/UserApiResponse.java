package com.example.study.model.network.response;

import java.time.LocalDateTime;
import java.util.List;

import com.example.study.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiResponse {
  private Long id;

  private String account;

  private String password;

  private String email;

  private UserStatus status;

  private String phoneNumber;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  private List<OrderGroupApiResponse> orderGroupApiResponseList;
}
