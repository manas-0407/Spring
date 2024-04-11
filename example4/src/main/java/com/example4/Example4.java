package com.example4;

import com.Bean4.Person;
import com.Bean4.Vehicle;
import com.BeanConfig.Configure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example4 {


    public static void main(String[] args) {
        /*
        instantiate and configure IOC container with our config class
         */

        var context = new AnnotationConfigApplicationContext(Configure.class);
        // IOC container initialized with my Configure class

        Vehicle vehicle = context.getBean(Vehicle.class);
        Person person = context.getBean(Person.class);

        System.out.println(vehicle.getVehicle_name());
        System.out.println(person.getName());
        System.out.println(person.getVehicle());
        // this person has a vehicle

    }
}
