package com.openmall.manager.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.openmall.manager","com.openmall.common.pojo"})
@SpringBootApplication
public class OpenmallManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenmallManagerWebApplication.class, args);
    }
}