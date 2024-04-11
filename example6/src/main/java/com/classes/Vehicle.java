package com.classes;

import com.interfaces.LogAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    @Autowired
    VehicleService vehicleService;


//    @LogAspect
    public String move(boolean vehicle_start) throws Exception {
        return vehicleService.move();
//        else throw new Exception("VEHICLE Not Start ! ");
    }

    public String brake(boolean vehicle_start) throws Exception {
        if(vehicle_start) return vehicleService.brake();
        else throw new Exception("VEHICLE Not Start ! ");
    }
    public String play(boolean vehicle_start) throws Exception {
        if(vehicle_start) return vehicleService.play();
        else throw new Exception("VEHICLE Not Start ! ");
    }
}
