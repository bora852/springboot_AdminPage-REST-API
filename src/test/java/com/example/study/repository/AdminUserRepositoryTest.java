package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.AdminUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends StudyApplicationTests {

        @Autowired
        AdminUserRepository repo;

        @Test
        public void create(){
            AdminUser admin = new AdminUser();
            admin.setAccount("user01");
            admin.setPassword("1234");
            admin.setStatus("regi");
            admin.setRole("partner");
//            admin.setCreatedAt(LocalDateTime.now());
//            admin.setCreatedBy("admin");

            AdminUser newAdmin = repo.save(admin);
            Assert.assertNotNull(newAdmin);

            newAdmin.setAccount("CHANGE");
            repo.save(newAdmin);

        }
}
