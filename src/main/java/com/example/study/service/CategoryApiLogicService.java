package com.example.study.service;

import com.example.study.model.entity.Category;
import com.example.study.model.entity.Item;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.CategoryApiRequest;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.CategoryApiResponse;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse, Category>{


    @Override
    public CategoryApiResponse response(Category category) {
        return null;
    }

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> req) {
        return null;
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> req) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}