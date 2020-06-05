package com.mealordev.projectmanagement.mealordev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/index", ""})
    public String main(Model model) {
        model.addAttribute("titulo", "Mealor Dev.");
        return "index";
    }
}
