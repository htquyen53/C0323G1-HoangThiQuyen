package com.example.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CurrencyConverter {
    @GetMapping("/currency_converter/form")
    public String showForm() {
        return "/converter";
    }

    @PostMapping("/currency_converter/converter")
    public String converter(@RequestParam float usd, Model model) {
        if (usd<0) {
            model.addAttribute("usd", usd);
            model.addAttribute("message", "Không hợp lệ, mời nhập một số dương!");
        } else {
            double vnd = usd * 23000;
            model.addAttribute("usd", usd);
            model.addAttribute("vnd", vnd);
        }
        return "/converter";
    }
}
