package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class SandwichController {
    @GetMapping
    public String showMenu() {
        return "/menu";
    }

    @PostMapping("/result")
    public ModelAndView save(@RequestParam(value = "sandwich", required = false) String[] sandwich) {
        ModelAndView modelAndView = new ModelAndView("/result");
        if (sandwich == null ||sandwich.length == 0) {
            modelAndView.addObject("msg", "Nothing");
        } else {
            modelAndView.addObject("listSandwich", sandwich);
        }
        return modelAndView;
    }

}
