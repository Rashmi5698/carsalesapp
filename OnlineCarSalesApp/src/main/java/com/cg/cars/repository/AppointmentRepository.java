package com.cg.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.cars.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
