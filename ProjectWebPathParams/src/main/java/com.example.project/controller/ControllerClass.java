package com.example.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ControllerClass {

    @RequestMapping(value = {"/" , "" , "/home"})
    public String homePage(Model model){
        model.addAttribute("username" , "Manas");
        return "home.html";
    }
}
