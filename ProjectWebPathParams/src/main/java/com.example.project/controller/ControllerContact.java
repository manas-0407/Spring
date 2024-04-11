package com.example.project.controller;

import java.util.logging.Logger;

import com.example.project.models.Contact;
import com.example.project.sevices.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.io.*;
import java.util.logging.Logger;

@Controller
public class ControllerContact {

    @RequestMapping(value = "/contact")
    public  String contact_page(){
        return "contact.html";
    }

    private final Logger log = Logger.getLogger(ControllerContact.class.getName());

//    @RequestMapping(value = "saveContact" , method = RequestMethod.POST)
//    public ModelAndView contact_save(@RequestParam String name ,@RequestParam String mobileNum ,@RequestParam String email,@RequestParam String subject,@RequestParam String message){
//
//        log.info("Name "+name);
//        log.info("Mobile number "+mobileNum);
//        log.info("Email "+email);
//        log.info("Subject "+subject);
//        log.info("Message "+ message);
//        return new ModelAndView("contact.html");
//    }

    @Autowired
    public ContactService contactService;

    @RequestMapping(value = "saveContact" , method = RequestMethod.POST)
    public ModelAndView contact_save( Contact contact ){
        boolean savedDetail = contactService.saveMessage(contact);
        return new ModelAndView("redirect:/contact");
    }
}
