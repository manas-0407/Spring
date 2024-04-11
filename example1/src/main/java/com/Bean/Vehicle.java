package com.Bean;

import org.springframework.stereotype.Component;

public class Vehicle {

    private String vehicle_name;

    public void setVehicle_name(String name){
        this.vehicle_name = name;
    }

    public String getVehicle_name(){
        return this.vehicle_name;
    }
}
