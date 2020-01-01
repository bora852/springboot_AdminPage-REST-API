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
        String account = "Test01";
        String password = "Test01";
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
        user.setCreatedAt(cre);
        user.setCreatedBy(creBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
        System.out.println("newUser : "+newUser);
    }

    @Test
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-6666-6666");
        Assert.assertNotNull(user);
//        user.ifPresent(selectUser -> {
//            System.out.println("user : " + selectUser);
//        });
    }


}
