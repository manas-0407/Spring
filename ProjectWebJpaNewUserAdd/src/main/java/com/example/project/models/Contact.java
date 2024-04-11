package com.example.project.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.io.*;

@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "contact_id")
    int contactId;

    @Column(name = "name")
    String name;

    @Column(name = "mobile_num")
    String mobile_num;

    @Column(name = "email")
    String email;

    @Column(name = "subject")
    String subject;

    @Column(name = "message")
    String message;

    @Column(name = "status")
    String status;
}
