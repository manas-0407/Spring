package com.example.examlpe7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerClass {

    @RequestMapping(value = {"/" , "" , "/home"})
    public String homePage(Model model){
        model.addAttribute("username" , "Manas");
        return "home.html";
    }
}
