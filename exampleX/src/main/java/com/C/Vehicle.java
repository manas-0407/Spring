package com.C;

import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;


@Component
public class Vehicle {
    String car = "Audi";
    public void move(){
        System.out.println("Moving " + car );
    }
}
