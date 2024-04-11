package com.example6;

import com.classes.MRF;
import com.classes.Vehicle;
import com.configure6.Configure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example6 {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configure.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle.getClass());
        boolean vehicle_start = true;
        System.out.println((vehicle.move(vehicle_start)));
        System.out.println((vehicle.play(vehicle_start)));
        System.out.println((vehicle.brake(vehicle_start)));
    }
}
