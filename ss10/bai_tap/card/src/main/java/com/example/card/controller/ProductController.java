package com.example.card.controller;

import com.example.card.dto.ProductDto;
import com.example.card.model.Cart;
import com.example.card.model.Product;
import com.example.card.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @GetMapping
    public ModelAndView showShop(Model model, @SessionAttribute(value = "cart",required = false)Cart cart
                               ) {
        model.addAttribute("historyProduct", productService.findAll());
        if (cart != null){
            model.addAttribute("cart",cart);
        }
        return new ModelAndView("shop","productList",productService.findAll());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute(value = "cart") Cart cart) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto =new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "/cart";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id, HttpServletResponse response){
        Cookie cookie = new Cookie("productId",id+"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail","product",productService.findById(id));
    }
    @GetMapping("/give/{id}")
    public String giveToCart(@PathVariable Long id,
                            @SessionAttribute(value = "cart") Cart cart) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto =new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.removeProduct(productDto);
        }
        return "/cart";
    }
    @GetMapping("/pay")
    public String pay(@SessionAttribute(value = "cart") Cart cart, RedirectAttributes redirectAttributes){
        float totalPrice = cart.countTotalPayment();
        String msg = "Đã thanh toán "+cart.getSize()+"sản phẩm thành tiền:"+totalPrice;
        redirectAttributes.addFlashAttribute("msg",msg);
        cart.clearAll();
        return "redirect:/cart";
    }
}

