package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import java.math.BigDecimal;
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

    orderDetail.setStatus("WATTING");
    orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
    orderDetail.setQuantity(1);
    orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
//    orderDetail.setOrderGroupId(1L);
//    orderDetail.setItemId(1L);
    orderDetail.setCreatedAt(LocalDateTime.now());
    orderDetail.setCreatedBy("AdminServer");

    OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
    Assertions.assertNotNull(newOrderDetail);

  }

}
