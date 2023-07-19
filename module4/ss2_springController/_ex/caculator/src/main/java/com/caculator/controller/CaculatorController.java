package com.caculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/")
    public String showCaculator() {
        return "/caculator";
    }

    @PostMapping("/caculator")
    public String cacutalor(@RequestParam(value = "firstOperator", required = false) double firstOperator, @RequestParam(value = "secondOperator", required = false) double secondOperator, @RequestParam(value = "operator", required = false) String operator, ModelMap model) {
        double result = 0;
        switch (operator) {
            case ("+"):
                result = firstOperator + secondOperator;
                break;
            case ("-"):
                result = firstOperator - secondOperator;
                break;
            case ("*"):
                result = firstOperator * secondOperator;
                break;
            case ("/"):
                if (secondOperator == 0) {
                    model.addAttribute("msg", "Phép chia cho 0 không hợp lệ!");
                } else {
                    result = firstOperator / secondOperator;
                }
                break;
            default:
                break;
        }
        model.addAttribute("firstOperator",firstOperator);
        model.addAttribute("secondOperator",secondOperator);
        model.addAttribute("result",result);
        return "/caculator";
    }

}
