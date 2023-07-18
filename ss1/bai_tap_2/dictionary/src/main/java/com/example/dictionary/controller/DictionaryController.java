package com.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("apple", "Táo");
        dictionary.put("book", "Sách");
        dictionary.put("table", "bàn");
        dictionary.put("banana","chuối");
    }

    @GetMapping("/home")
    public String showForm() {
        return "home";
    }

    @PostMapping("/home")
    public String interpret(@RequestParam String search, Model model) {
        model.addAttribute("name", search);
        String nameSearch = search.trim().toLowerCase();
        String msg;
        if (dictionary.containsKey(nameSearch)) {
            msg = dictionary.get(nameSearch);
        }else {
            msg = "No result";
        }
          model.addAttribute("msg",msg);
        return "home";
    }
}
