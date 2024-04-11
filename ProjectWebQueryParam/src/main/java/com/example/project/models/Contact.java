package com.example.project.models;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.io.*;

@Data
public class Contact {
    String name;
    String mobileNum;
    String email;
    String subject;
    String message;
}
