package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Consumer;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        String account = "Test03";
        String password = "Test03";
        String status = "Regi";
        String email = "test@google.com";
        String phone = "010-6666-6666";
        LocalDateTime rgi = LocalDateTime.now();
        LocalDateTime cre = LocalDateTime.now();
        String creBy = "admin";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        user.setRegisteredAt(rgi);
//        user.setCreatedAt(cre);
//        user.setCreatedBy(creBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-6666-6666");

        if(user != null){
            System.out.println("------------------주문묶음-------------------");
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println(orderGroup.getTotalPrice());
                System.out.println(orderGroup.getRevAddress());
                System.out.println(orderGroup.getRevName());
                System.out.println(orderGroup.getTotalQuantity());

                System.out.println("------------------주문상세-------------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : "+orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : "+orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : "+ orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : "+ orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println(orderDetail.getStatus());
                    System.out.println(orderDetail.getArrivalDate());




                });

            });
        }
        Assert.assertNotNull(user);
    }


}
