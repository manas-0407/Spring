package com.example.project.models;

import lombok.Data;

import java.util.*;
import java.io.*;

@Data
public class Holiday {
    private String reason;
    private String day;
    private Type type;

    public enum Type{
        FESTIVAL,
        FEDERAL
    }

    public Holiday(String reason,String day,Type type){
        this.reason = reason;
        this.day = day;
        this.type = type;
    }
}
