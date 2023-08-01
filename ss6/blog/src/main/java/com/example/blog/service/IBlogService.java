package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findALl(Pageable pageable, String name);

    void add(Blog blog);

    void delete(Blog blog);

    Blog findById(int id);

     void edit(Blog blog);
     List<Blog> findCategoryId(int category_id);
     List<Blog> findListAll();
}
