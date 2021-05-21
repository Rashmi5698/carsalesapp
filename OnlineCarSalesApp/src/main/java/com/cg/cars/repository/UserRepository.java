package com.cg.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.cg.cars.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	

	
}
