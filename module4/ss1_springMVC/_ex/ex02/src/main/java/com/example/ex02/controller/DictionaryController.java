package com.example.ex02.controller;

import com.example.ex02.respository.IDictionaryRepository;
import com.example.ex02.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;
    @GetMapping("/dictionary")
    public String searchForm() {
        return "/dictionary";
    }
    @PostMapping("/dictionary/search")
    public String search(@RequestParam String searchWord, Model model) {
        String result = iDictionaryService.search(searchWord);
        if (result == null) {
            model.addAttribute("msg","Not exist!");
        }
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("result",result);
        return "/dictionary";
    }
}
