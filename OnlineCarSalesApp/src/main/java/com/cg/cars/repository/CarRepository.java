package com.cg.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.cars.entities.Car;




@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	@Query("select b from Car b where b.brand=:brand")
	List<Car> findByBrand(String brand);
	
	@Query("select l form Car l where l.registrationState=:registrationState")
	List<Car> findByLocation(String registrationState);
	
	@Query("select m from Car m where m.model=:model")
	List<Car> findByModel(String model);
	
	
	
	

	
}
