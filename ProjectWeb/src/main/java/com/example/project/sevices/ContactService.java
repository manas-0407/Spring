package com.example.project.sevices;

import com.example.project.models.Contact;
import org.springframework.stereotype.Service;

import java.util.*;
import java.io.*;
import java.util.logging.Logger;

@Service
public class ContactService {

    private Logger log = Logger.getLogger(ContactService.class.getName());

    public boolean saveMessage(Contact contact){
        boolean issaved = true; // get this from repository layer
        log.info(contact.toString());
        return issaved;
    }

}
