package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findALlPage(Pageable pageable, String name);

    void add(Category category);

    void delete(int id);

    Category findById(int id);
    List<Category> findAll();
}
