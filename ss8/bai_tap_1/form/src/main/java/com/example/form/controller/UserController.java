package com.example.form.controller;

import com.example.form.model.User;
import com.example.form.dto.UserDto;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("/form")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/form");
        UserDto userDto = new UserDto();
        modelAndView.addObject("userDto", userDto);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
        User user = new User();
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/form");
        }
        BeanUtils.copyProperties(userDto, user);
        iUserService.add(user);
        return new ModelAndView("result");


    }

}
