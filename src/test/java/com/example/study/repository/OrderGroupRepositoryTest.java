package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import com.example.study.model.entity.OrderGroup;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends StudyApplicationTests {
    @Autowired
    private OrderGroupRepository repo;

    @Test
    public void create(){
        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus("waiting");
        orderGroup.setOrderType("all");
        orderGroup.setRevAddress("서울시");
        orderGroup.setRevName("보라");
        orderGroup.setPaymentType("card");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("admin");
        //orderGroup.setUserId(1L);

        OrderGroup newOrderDetail = repo.save(orderGroup);
        Assert.assertNotNull(newOrderDetail);
    }
}
