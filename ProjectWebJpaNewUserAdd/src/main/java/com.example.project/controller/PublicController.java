package com.example.project.controller;

import com.example.project.models.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

@Controller
@RequestMapping("/public")
public class PublicController {

    @RequestMapping(value =  "/register")
    public String register(Model model){
        model.addAttribute("person",new Person());
        return "register.html";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute(value = "person") Person person, Errors errors){

        print(person);

        if(errors.hasErrors()){
            return "register.html";
        }

        return "redirect:/login?register=true";

    }

    public void print(Person person){
        System.err.println("Person ID: "+person.getPersonId());
        System.err.println("Name: " + person.getName());
        System.err.println("Email: " + person.getEmail());
        System.err.println("Mobile Number: " + person.getMobileNumber());
        System.err.println("Password: " + person.getPwd());
    }

}
