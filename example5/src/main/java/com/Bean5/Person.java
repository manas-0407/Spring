package com.Bean5;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component
public class Person {
    private String person;
    private final Vehicle vehicle;

    @PostConstruct
    void setName(){
        this.person =  "Manas";
    }

    @Autowired
    Person(Vehicle vehicle){
        System.out.println("Inside person contruct");
        this.vehicle = vehicle;
    }

    public String getPerson(){
        return this.person;
    }

    public String getPersonVehicle(){
        return this.person+" own "+this.vehicle.getVehicle();
    }

    public void getVehicleInfo(){
        vehicle.vehicle_tyre();
        vehicle.vehicle_speaker();
    }
}
