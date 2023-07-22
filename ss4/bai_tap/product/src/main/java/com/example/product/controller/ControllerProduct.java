package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerProduct {
    @Autowired
    private IServiceProduct iServiceProduct;

    @GetMapping("/list")
    public ModelAndView showList() {
        List<Product> productList = iServiceProduct.displayAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public String showUpdate(Model model, @PathVariable int id) {
        Product product = iServiceProduct.getById(id);
        model.addAttribute("productUpdate", product);
        return "/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "XÓa thành công");
        iServiceProduct.remove(id);
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }
@PostMapping("/create")
    public String create( @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iServiceProduct.add(product);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iServiceProduct.update(product);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:/list";
    }
    @PostMapping("/search")
    public ModelAndView searchName(@RequestParam String search){
        List<Product> productList = iServiceProduct.searchName(search);
        System.out.println(search);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }
}
