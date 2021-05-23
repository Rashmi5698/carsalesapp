package com.cg.cars;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ch.qos.logback.classic.Logger;



@SpringBootApplication
//@ComponentScan(basePackages="com.cg.cars")
public class OnlineCarSalesApp {
	//static final Logger LOGGER = LoggerFactory.getLogger(OnlineCarSalesApp.class);

	public static void main(String[] args) {
		
		//LOGGER.info("Online Flat Rental Application Initiated");
		
		SpringApplication.run(OnlineCarSalesApp.class, args);
		

	}

}
