package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends StudyApplicationTests {

    @Autowired
    private PartnerRepository repo;

    @Test
    public void create(){
        Partner partner = new Partner();
         partner.setName("partner01");
         partner.setStatus("reg");
         partner.setAddress("목포");
         partner.setCallCenter("070");
         partner.setPartnerNumber("010");
         partner.setBusinessNumber("123");
         partner.setCeoName("길동");
         partner.setRegisteredAt(LocalDateTime.now());
         partner.setCreatedAt(LocalDateTime.now());
         partner.setCreatedBy("admin");
        //partner.setCategoryId(1L);
         Partner newPartner = repo.save(partner);
        Assert.assertNotNull(newPartner);
    }
}
