package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public ModelAndView showList() {
        List<Product> productList = iProductService.displayAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public String showUpdate(Model model, @PathVariable int id) {
        Product product = iProductService.getById(id);
        model.addAttribute("productUpdate", product);
        return "/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean check = iProductService.remove(id);
        if (check) {
            redirectAttributes.addFlashAttribute("msg", "XÓa thành công");

        } else {
            redirectAttributes.addFlashAttribute("msg", "Lỗi! đối tượng sẽ không đc xóa");

        }
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        boolean check = iProductService.add(product);
        if (check) {
            redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Lỗi! Sản Phẩm chưa được cập nhật");
        }
        return "redirect:/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        boolean check = iProductService.update(product);
        if (check) {
            redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Lỗi! Cập nhật không công");
        }


        return "redirect:/list";
    }

    @PostMapping("/search")
    public ModelAndView searchName(@RequestParam String search) {
        List<Product> productList = iProductService.searchName(search);
        System.out.println(search);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("productList", productList);
        if (productList.size() == 0) {
            modelAndView.addObject("msg", "Không thấy kết quả phù hợp");
        }
        return modelAndView;
    }
}
