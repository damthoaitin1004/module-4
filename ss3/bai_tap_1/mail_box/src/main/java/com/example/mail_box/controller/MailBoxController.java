package com.example.mail_box.controller;

import com.example.mail_box.model.MailBox;
import com.example.mail_box.service.IMailBoxService;
import com.example.mail_box.service.MailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailBoxController {
    @Autowired
    private  IMailBoxService mailBoxService;
    @GetMapping("/update")
    public String showUpdate(Model model) {
        model.addAttribute("mailBox",mailBoxService.display());
        return "/update";
    }
    @GetMapping("/home")
  public String showHome(Model model){
      model.addAttribute("mailBox",mailBoxService.display());
      return "/home";
  }
  @PostMapping("/update")
  public String update(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes){
       mailBoxService.update(mailBox);
       redirectAttributes.addFlashAttribute("msg","Update complete !");
       return "redirect:/home";

  }
    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"English","Vietnamese","Japanese","Chinese"};
    }
    @ModelAttribute("pageSize")
    public int[] getPageSize(){
        return new int[]{5, 10, 15, 25, 50, 100};
    }

}
