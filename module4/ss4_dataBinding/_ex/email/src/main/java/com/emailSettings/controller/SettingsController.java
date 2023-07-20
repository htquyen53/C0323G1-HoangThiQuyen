package com.emailSettings.controller;

import com.emailSettings.model.Settings;
import com.emailSettings.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/email-settings")
public class SettingsController {
    @Autowired
    @Qualifier("settingsService")
    private ISettingsService iSettingsService;

    @ModelAttribute("languages")
    public String[] getLanguages() {
        return new String[]{"English", "Vietnamese", "French"};
    }

    @ModelAttribute("pageSize")
    private Integer[] getPageSize() {
        return new Integer[]{5, 10, 15, 20, 25, 50, 100};
    }

    @GetMapping("/showInfo")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("settings", iSettingsService.getSettings());
        System.out.println(iSettingsService.getSettings().isSpamsFilter());
        return modelAndView;
    }

    @GetMapping("/update")
    public String showFormUpdate(ModelMap model) {
        model.addAttribute("settings", iSettingsService.getSettings());
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("settings") Settings settings, RedirectAttributes redirectAttributes) {
        iSettingsService.update(settings);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/email-settings/showInfo";
    }

}
