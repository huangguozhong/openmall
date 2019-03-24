package com.openmall.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan({"com.openmall.rest"})
@SpringBootApplication
public class OpenmallRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenmallRestApplication.class, args);
	}
}