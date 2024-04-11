package com.example3;

import com.Bean3.Vehicle;
import com.BeanConfig.Configure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;


public class Example3 {

    public static void main(String[] args) {

        Vehicle v1= new Vehicle();
        v1.setVehicle_name("Honda");
        System.out.println("POJO Object "+v1.getVehicle_name());

        /*
        instantiate and configure IOC container with our config class
         */


        var context = new AnnotationConfigApplicationContext(Configure.class);
        // IOC container initialized with my Configure class

        Vehicle veh1 = new Vehicle();
        veh1.setVehicle_name("AUdi");
        Supplier<Vehicle> sup1 = ()-> veh1;
        context.registerBean("bean1" , Vehicle.class , sup1);


        Vehicle veh2 = new Vehicle();


        veh2.setVehicle_name("Mercedes");
        context.registerBean("bean2" , Vehicle.class , ()->veh2);

        Vehicle v2 = context.getBean("bean2",Vehicle.class);
        System.out.println("Spring initialized object: "+ v2.getVehicle_name());

        System.out.println(Long.toBinaryString(481885160128643072L));
        System.out.println("000"+Long.toBinaryString(45035996273704960L));
        System.out.println(481885160128643072L ^ 45035996273704960L);

        context.close();
    }
}
