package com.Bean5;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component(value = "boat_speaker")
public class BoatSpeaker implements Speaker{

    @PostConstruct
    void tell(){
        System.out.println("Boat Speaker");
    }

    @Override
    public void makesound() {
        System.out.println("Sound from Boat Speaker");
    }
}
