package com.example.project.sevices;

import com.example.project.models.Contact;
import com.example.project.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessage(Contact contact){

        boolean issaved = false; // get this from repository layer
        contact.setStatus("OPEN");
        contact.setCreated_by("ANONYMOUS");
        contact.setCreated_at(LocalDateTime.now());
        int rows_update = contactRepository.save(contact);
        if(rows_update > 0){
            issaved = true;
        }
        return issaved;
    }

    public List<Contact> findMessagesByStatus(String status) {
        return contactRepository.getContactByStatus(status);
    }

    public void close_status(int id,String updated_by) {
        contactRepository.close_message_(id, updated_by);
    }
}
