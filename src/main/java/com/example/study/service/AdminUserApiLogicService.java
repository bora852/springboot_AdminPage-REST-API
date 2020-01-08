package com.example.study.service;

import com.example.study.model.entity.AdminUser;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.AdminUserApiRequest;
import com.example.study.model.network.response.AdminUserApiResponse;
import org.springframework.stereotype.Service;


@Service
public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest, AdminUserApiResponse, AdminUser>{


    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> req) {
        AdminUserApiRequest body = req.getData();
        AdminUser adminUser = AdminUser.builder()
                .account(body.getAccount())
                .password(body.getPassword())
                .status(body.getStatus())
                .role(body.getRole())
                .registeredAt(body.getRegisteredAt())
                .build();

        AdminUser newAdminUser = baseRepository.save(adminUser);
        return Header.OK(response(newAdminUser));
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(admin -> response(admin))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> req) {
        AdminUserApiRequest body = req.getData();

        return baseRepository.findById(req.getData().getId())
                .map(adminUser -> {
                    adminUser.setAccount(body.getAccount())
                            .setRole(body.getRole())
                            .setStatus(body.getStatus())
                            .setPassword(body.getPassword());
                    return adminUser;
                })
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
        .map(admin -> {
            baseRepository.delete(admin);
            return Header.OK();
        })
        .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public AdminUserApiResponse response(AdminUser adminUser) {
        AdminUserApiResponse body = AdminUserApiResponse.builder()
                                        .id(adminUser.getId())
                                        .account(adminUser.getAccount())
                                        .password(adminUser.getPassword())
                                        .status(adminUser.getStatus())
                                        .role(adminUser.getRole())
                                        .lastLoginAt(adminUser.getLastLoginAt())
                                        .loginFailCount(adminUser.getLoginFailCount())
                                        .registeredAt(adminUser.getRegisteredAt())
                                        .unregisteredAt(adminUser.getUnregisteredAt())
                                        .build();
        return body;
    }
}
