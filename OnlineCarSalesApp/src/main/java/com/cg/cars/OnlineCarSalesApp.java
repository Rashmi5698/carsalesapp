package com.cg.cars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class OnlineCarSalesApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(OnlineCarSalesApp.class);

	public static void main(String[] args) {

		LOGGER.info("Online Car Sales Application Initiated");

		SpringApplication.run(OnlineCarSalesApp.class, args);

	}
}
