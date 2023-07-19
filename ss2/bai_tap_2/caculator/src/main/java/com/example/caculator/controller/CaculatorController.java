package com.example.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping
    public String showHome() {
        return "/home";
    }

    @PostMapping("/save")
    public String save(@RequestParam String numberOne, @RequestParam String numberTwo, @RequestParam String caculator, Model model) {
        int result = 0;
        int numberA = 0;
        int numberB = 0;
        String msg = null;
        try {
            numberA = Integer.parseInt(numberOne);
            numberB = Integer.parseInt(numberTwo);

            switch (caculator) {
                case "+":
                    result = numberA + numberB;
                    break;
                case "-":
                    result = numberA - numberB;
                    break;
                case "*":
                    result = numberA * numberB;
                    break;
                case "/":
                    if (numberB != 0) {
                        result = numberA / numberB;
                    } else {
                        msg = "Error";
                    }
                    break;
                default:
                    break;
            }
        }catch (NumberFormatException n){
            msg = "Number format";
        }
        model.addAttribute("result", result);
        model.addAttribute("msg",msg);
        return "/home";

    }
}
