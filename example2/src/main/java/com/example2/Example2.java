package com.example2;

import com.Bean.Vehicle;
import com.BeanConfig.Configure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.geom.Area;
import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {

        Vehicle v1= new Vehicle();
        v1.setVehicle_name("Honda");
        System.out.println("POJO Object "+v1.getVehicle_name());

        /*
        instantiate and configure IOC container with our config class
         */


        var context = new AnnotationConfigApplicationContext(Configure.class);
        // IOC container initialized with my Configure class

        Vehicle v2 = context.getBean(Vehicle.class);
        System.out.println("Spring initialized object: "+ v2.getVehicle_name());

        context.close();
    }
}
