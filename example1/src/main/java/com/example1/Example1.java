package com.example1;

import com.Bean.Vehicle;
import com.BeanConfig.Configure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class Example1 {
    public static void main(String[] args) {

        Vehicle v1= new Vehicle();
        v1.setVehicle_name("Honda");
        System.out.println("POJO Object "+v1.getVehicle_name());

        /*
        initiale and configuer IOC container with our config class
         */

        var context = new AnnotationConfigApplicationContext(Configure.class);
        // IOC container initialized with my Configure class
//        Vehicle v2 = context.getBean("veh1",Vehicle.class);
//        Vehicle v3 = context.getBean("veh2",Vehicle.class);
        Vehicle v2 = context.getBean(Vehicle.class);
        System.out.println("Spring initialized object: "+ v2.getVehicle_name());
//        System.out.println("Spring initialized object: "+ v3.getVehicle_name());

    }
}
