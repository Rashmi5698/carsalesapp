package com.cg.cars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.cg.cars")
public class OnlineCarSalesApp {

	public static void main(String[] args) {
		
		SpringApplication.run(OnlineCarSalesApp.class, args);
		System.out.println("Hello World");

	}

}
