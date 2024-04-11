package com.Bean5;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component
public class VehicleService {

    @Autowired
    @Qualifier("bridge_stone_tyre")
    private Tyre tyre;

    @Autowired
    @Qualifier("jbl_speaker")
    private Speaker speaker;


    @PostConstruct
    void tell(){
        System.out.println("Vehicle service");
    }

    void tyreService(){
        tyre.tyreName();
    }

    void speakerService(){
        speaker.makesound();
    }
}
