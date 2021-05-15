package com.cg.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import com.cg.cars.entities.Address;
import com.cg.cars.entities.Card;


@Repository
public interface CardRepository extends JpaRepository<Card, String> {
	

	
}
