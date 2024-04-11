package com.example.project.controller;

import java.util.logging.Logger;

import com.example.project.models.Contact;
import com.example.project.sevices.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.io.*;
import java.util.logging.Logger;

@Slf4j
@Controller
public class ControllerContact {

    @RequestMapping(value = "/contact")
    public  String contact_page(){
        return "contact.html";
    }

    @Autowired
    public ContactService contactService;

    @RequestMapping(value = "saveContact" , method = RequestMethod.POST)
    public ModelAndView contact_save(Contact contact) {
        boolean savedDetail = contactService.saveMessage(contact);
        return new ModelAndView("redirect:/contact");
    }

    @RequestMapping(value = "displayMessages")
    public ModelAndView displayMessage_controller() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("messages.html");
        List<Contact> contacts = contactService.findMessagesByStatus("OPEN");
        modelAndView.addAllObjects(new HashMap<>(){
            {
                put("contactMsgs", contacts);
            }
        });
        return modelAndView;
    }

    @RequestMapping( value = "/closeMsg")
    public String close_message(@RequestParam int id){

        contactService.close_status(id);
        return "redirect:/displayMessages";
    }
}
