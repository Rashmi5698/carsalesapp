package com.cg.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.cars.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
