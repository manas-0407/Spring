package com.Bean4;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String vehicle_name = "Audi"; // can be post construct

//    public void setVehicle_name(String name){
//        this.vehicle_name = name;
//    }

    public String getVehicle_name(){
        return this.vehicle_name;
    }
}
