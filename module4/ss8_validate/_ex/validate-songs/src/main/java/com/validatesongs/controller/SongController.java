package com.validatesongs.controller;

import com.validatesongs.dto.SongDto;
import com.validatesongs.model.Song;
import com.validatesongs.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/play-music-free")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        Song song = new Song();
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            return "create";
        }
        BeanUtils.copyProperties(songDto, song);
        boolean check = songService.add(song);
        if (check) {
            redirectAttributes.addFlashAttribute("message", "Add New Song Successful!");
            return "redirect:/play-music-free/create";
        }
        return "create";
    }
}
