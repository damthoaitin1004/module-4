package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("/list")
    public ModelAndView showCategory(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("name").ascending());
        Page<Category> categoryPage = categoryService.findALlPage(pageable, searchName);
        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("categoryPage", categoryPage);
        modelAndView.addObject("searchName", searchName);
        return modelAndView;
    }
    @GetMapping("/createCategory")
    public String showCreate(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "createCategory";
    }
    @PostMapping("/createCategory")
    private String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/category/list";
    }
    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/category/list";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("detail");
      List<Blog> blogList = blogService.findCategoryId(id);
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }
}
