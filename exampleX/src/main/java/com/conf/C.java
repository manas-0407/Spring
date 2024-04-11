package com.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Configuration
@ComponentScan( basePackages = "com.C")
@EnableAspectJAutoProxy
public class C {

}
