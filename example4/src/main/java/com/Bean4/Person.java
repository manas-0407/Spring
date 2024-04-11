package com.Bean4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    // person owns a vehicle
    // person class is linked to vehicle class,there is a relation between person and vehicle class

    @Autowired
    Person(Vehicle vehicle){
        System.out.println("Inside Person const");
        this.vehicle = vehicle;
    }

    private String name ="Manas";

    private final Vehicle vehicle;

//    public void setName(String name){
//        this.name = name;
//    }

    public String getName(){
        return this.name;
    }

    /*
    Autowiring can be on field or if on a method or constructor, the method/constructor should that the dependency class as parameter

     */
//    @Autowired
//    public void setVehicle(Vehicle vehicle){
//        this.vehicle = vehicle;
//    }

    public String getVehicle(){
        try{
            return vehicle.getVehicle_name();
        }catch (Exception e){
            return null;
        }
    }
}
