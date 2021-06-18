package com.example.study.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"user", "item"})
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private String status;

  private LocalDate arrivalDate;

  private LocalDateTime createdAt;

  private String createdBy;

  private Long orderGroupId;

  // N : 1
  @ManyToOne
  private User user; // user_id

  // N : 1
  @ManyToOne
  private Item item;



}
