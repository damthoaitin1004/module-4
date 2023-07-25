package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findALl();

    void add(Blog blog);

    void delete(Blog blog);

    Blog findById(int id);

     void edit(Blog blog);
}
