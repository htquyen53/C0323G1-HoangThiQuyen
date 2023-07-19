package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String display() {
        return "/sandwich-index";
    }

    @RequestMapping("/sandwich")
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment, ModelMap model) {
        List<String> listCondiment = Arrays.asList(condiment);
        if (listCondiment.size() > 0) {
            model.addAttribute("listCondiment", listCondiment);
        } else {
            model.addAttribute("msg", "You haven't selected!");
        }
        return "/sandwich-index";
    }

}
