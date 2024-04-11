package com.Bean5;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component(value = "mrf_tyre")
@Primary
public class MRF implements Tyre{

    @PostConstruct
    void tell(){
        System.out.println("MRF Tyre");
    }

    @Override
    public void tyreName() {
        System.out.println("MRF tyres");
    }
}
