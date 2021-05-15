package com.cg.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import com.cg.cars.entities.Car;



@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	

	
}
