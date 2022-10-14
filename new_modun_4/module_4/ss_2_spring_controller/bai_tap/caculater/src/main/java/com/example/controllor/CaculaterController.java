package com.example.controllor;

import com.example.service.ICaculater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculaterController {

    @Autowired
    private ICaculater iCaculater;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/result")
    public String result(@RequestParam double number1, @RequestParam double number2, @RequestParam String option, Model model) {
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", iCaculater.caculater(number1, number2, option));
        return "index";
    }
}
