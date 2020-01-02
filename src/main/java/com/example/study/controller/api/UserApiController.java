package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")       // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") //  /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable Long id) {
        log.info("read is : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> req) {
        return userApiLogicService.update(req);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(Long id) {
        return null;
    }
}