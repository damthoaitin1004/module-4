package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView showDisplay() {
        List<Blog> blogList = blogService.findALl();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList", categoryService.findALl());
        return "create";
    }

    @PostMapping("/create")
    private String create(@ModelAttribute Blog blog,@RequestParam int categoryId,RedirectAttributes redirectAttributes){
        Category category = categoryService.findById(categoryId);
        blog.setCategory(category);
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("msg","Bài viết đã được đăng");
        return "redirect:/blog/list";
    }
    @RequestMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id,Model model){
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findALl();
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",categoryList);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,@RequestParam int categoryId, RedirectAttributes redirectAttributes){
        Category category = categoryService.findById(categoryId);
        blog.setCategory(category);
        blogService.edit(blog);
        redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thành công");
        return "redirect:/blog/list";
    }
}
