package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where category_id = :category_id",nativeQuery = true)
    List<Blog> searchCategoryId(@Param(value = "category_id") int category_id);
    Page<Blog> findBlogsByNameContaining(Pageable pageable, String name);

}
