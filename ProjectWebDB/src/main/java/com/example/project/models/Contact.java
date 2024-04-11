package com.example.project.models;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.io.*;

@Data
public class Contact extends BaseEntity{
    int contactId;
    String name;
    String mobile_num;
    String email;
    String subject;
    String message;
    String status;
}
