package com.example.music.controller;

import com.example.music.dto.MusicDto;
import com.example.music.model.Music;
import com.example.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("musicDto") MusicDto musicDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Music music = new Music();
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
           model.addAttribute("musicDto",musicDto);
           return "/create";
        }
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.add(music);
        redirectAttributes.addFlashAttribute("msg","Create complete!");
        return "redirect:/music/list";

    }

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("list", iMusicService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicDto", new MusicDto());
        return modelAndView;
    }
    @RequestMapping("/update/{id}")
    public String showFormUpdate(Model model, @PathVariable int id){
        Music music = iMusicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music,musicDto);
        model.addAttribute("musicDto",musicDto);
        model.addAttribute("id",music.getId());
        return "update";
    }
    @PostMapping("/update")
    public String update(@Valid@ModelAttribute MusicDto musicDto ,BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        Music music = new Music();
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "update";
        }
        BeanUtils.copyProperties(musicDto,music);
        iMusicService.add(music);
        redirectAttributes.addFlashAttribute("msg","Update successful!");
        return "redirect:/music/list";
    }
}
