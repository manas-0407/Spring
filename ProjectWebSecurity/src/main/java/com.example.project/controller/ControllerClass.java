package com.example.project.controller;

import com.example.project.static_config.SecurityConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ControllerClass {

    @RequestMapping(value = {"/" , "" , "/home"})
    public String homePage(Model model){
        System.err.println("Home");
        model.addAttribute("username" , "Manas");
        return "home.html";
    }

    @RequestMapping(value = "/login")
    public String login_page(@RequestParam(value = "error" ,required = false) String error, @RequestParam(value = "logout" ,required = false) String logout,Model model){

        System.err.println("Login");
        String message = null;
        if(error!=null){
            message = "Incorrect Username or Password";
        }
        if(logout != null){
            message = "Successful Logout";
        }

        log.info("Error: "+error+"\t Logout: "+logout);

        model.addAttribute("errorMessge" , message);
        return "login.html";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request , HttpServletResponse response){
        System.err.println("LOGout");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/login?logout=true";
    }
}
