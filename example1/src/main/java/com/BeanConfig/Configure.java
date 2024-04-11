package com.BeanConfig;

import com.Bean.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Configure {

    @Bean("veh1")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setVehicle_name("Audi_X");
        return veh;
    }

    @Primary // makes default bean for vehicle class so if no name is passed in context, this one will get called

    @Bean("veh2")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setVehicle_name("Audi_Y");
        return veh;
    }
}
