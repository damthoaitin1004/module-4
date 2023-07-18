package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {

    @GetMapping("/home")
    public String showForm(){
        return "home";
    }
    @PostMapping("/home")
    public String convert(@RequestParam int number,Model model){
        String result = number*23000+" VNĐ";
        model.addAttribute("result",result);
        return "home";
    }
}
