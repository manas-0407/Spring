package com.example.project.static_config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.Authenticator;
import java.util.*;
import java.io.*;

@Controller
public class DashBoardController {
    @RequestMapping(value = "/dashboard")
    public String dashPage(Model model, Authentication authentication){

        model.addAttribute("username",authentication.getName());
        model.addAttribute("roles",authentication.getAuthorities().toString());
        return "dashboard.html";
    }
}
