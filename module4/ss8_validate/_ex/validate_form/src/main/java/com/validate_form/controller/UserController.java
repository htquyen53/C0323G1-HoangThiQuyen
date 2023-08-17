package com.validate_form.controller;

import com.validate_form.dto.UserDto;
import com.validate_form.model.User;
import com.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        User user = new User();
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "index";
        }
        BeanUtils.copyProperties(userDto, user);
        boolean check = userService.add(user);
        if (check) {
            redirectAttributes.addFlashAttribute("message", "Create new successful!");
            return "redirect:user/result";
        }
        return "index";
    }
}
