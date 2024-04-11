package com.example5;

import com.Bean5.Person;
import com.configure5.ConfigurationIOC;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example5 {
    public static void main(String[] a){
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(ConfigurationIOC.class); // IOC context
        Person person = context.getBean(Person.class);
        System.out.println(person.getPerson());
        System.out.println(person.getPersonVehicle());
        person.getVehicleInfo();
    }
}
