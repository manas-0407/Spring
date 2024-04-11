package com.example.project.models;

import lombok.Data;

import java.util.*;
import java.io.*;

@Data
public class Holiday {
    private String reason;
    private String day;
    private String type;

    public Holiday(String reason,String day,String type){
        this.reason = reason;
        this.day = day;
        this.type = type;
    }
}
