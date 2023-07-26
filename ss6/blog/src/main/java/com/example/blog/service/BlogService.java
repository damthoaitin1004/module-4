package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findALl(Pageable pageable, String name) {
        return iBlogRepository.findBlogsByNameContaining(pageable,name);
    }



    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findCategoryId(int category_id) {
        return iBlogRepository.searchCategoryId(category_id);
    }
}
