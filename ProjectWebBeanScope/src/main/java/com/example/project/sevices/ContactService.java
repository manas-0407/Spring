package com.example.project.sevices;

import com.example.project.models.Contact;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;
import java.io.*;
import java.util.logging.Logger;

//@RequestScope
@SessionScope
@Service
public class ContactService {

    private Logger log = Logger.getLogger(ContactService.class.getName());

    int counter;

    ContactService(){
        System.out.println("Service Bean Init");
        log.info("Service bean init");
        counter = 0;
    }

    public boolean saveMessage(Contact contact){
        counter ++;
        boolean issaved = true; // get this from repository layer
        log.info(contact.toString());
        return issaved;
    }

    public int getCounter(){
        return counter;
    }
}
