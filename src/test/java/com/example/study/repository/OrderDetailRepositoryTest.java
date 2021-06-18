package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Test
  public void create() {
    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setStatus("status");
    orderDetail.setArrivalDate(LocalDate.now());
    orderDetail.setCreatedAt(LocalDateTime.now());
    orderDetail.setCreatedBy("created");
    orderDetail.setOrderGroupId(0L);
//    orderDetail.setUserId(7L);
//    orderDetail.setItemId(1L);

    OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
    Assertions.assertNotNull(newOrderDetail);

  }

}
