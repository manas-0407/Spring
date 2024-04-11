package com.Bean5;

import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component(value = "jbl_speaker")
public class JBL implements Speaker{

    @Override
    public void makesound(){
        System.out.println("Sound from JBL speaker");
    }
}
