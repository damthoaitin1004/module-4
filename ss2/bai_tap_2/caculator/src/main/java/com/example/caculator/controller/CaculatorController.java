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
        float result = 0;
        float numberA = 0;
        float numberB = 0;
        String msg = null;
        try {
            numberA = Float.parseFloat(numberOne);
            numberB = Float.parseFloat(numberTwo);

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
                    result = numberA / numberB;
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException n) {
            msg = "Wrong number format";
        } catch (ArithmeticException a) {
            msg = "undivided error: "+numberA+" cannot be divided by "+numberB;
        }
        model.addAttribute("result", result);
        model.addAttribute("msg",msg);
        return "/home";

    }
}
