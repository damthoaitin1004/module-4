package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/category")
public class RestCategoryController {
    @Autowired
   private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<Page<Category>> getList(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "") String searchName){
        Pageable pageable = PageRequest.of(page, 2, Sort.by("name").ascending());
        Page<Category> categoryPage = categoryService.findALlPage(pageable, searchName);
        if (categoryPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage,HttpStatus.OK);
    }
      @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> getBlogById(@PathVariable int id){
          List<Blog> blogList = blogService.findCategoryId(id);
          if (blogList.isEmpty()){
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(blogList,HttpStatus.OK);
      }

}
