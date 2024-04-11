package com.Bean5;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component
public class Vehicle {

    private String vehicle;
    private final VehicleService vehicleService;

    @Autowired
    Vehicle(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    void setVehicle(){
//        Scanner sc=new Scanner(System.in);
        System.out.println("Inside vehicle init");
        this.vehicle = "AudiX";
    }

    String getVehicle(){
        return this.vehicle;
    }

    void vehicle_tyre(){
        System.out.print(this.vehicle+" runs on ");
        vehicleService.tyreService();
    }

    void vehicle_speaker(){
        System.out.print(this.vehicle+" uses on ");
        vehicleService.speakerService();;
    }

}
