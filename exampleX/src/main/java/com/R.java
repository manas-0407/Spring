package com;

import com.C.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.conf.C;

import java.lang.reflect.Proxy;

public class R {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(C.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        boolean isProxy = Proxy.isProxyClass(vehicle.getClass());
        System.out.println(isProxy);
        System.out.println(vehicle.getClass());
        vehicle.move();
    }
}
