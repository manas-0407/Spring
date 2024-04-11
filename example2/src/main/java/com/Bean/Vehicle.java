package com.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class Vehicle {

    private String vehicle_name;

    public void setVehicle_name(String name){
        this.vehicle_name = name;
    }

    @PostConstruct
    void init(){
        this.vehicle_name = "Merc";
    }

    @PreDestroy
    void dest(){
        System.out.println("Destroying this Bean!");
    }

    public String getVehicle_name(){
        return this.vehicle_name;
    }
}
