package com.cg.cars.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.services.AppointmentService;

import com.cg.cars.model.AppointmentDTO;

import com.cg.cars.entities.Appointment;

//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@PostMapping("/add-appointment")
	public ResponseEntity<Object> insertAppointment(@RequestBody Appointment appointment)
	{
		AppointmentDTO appointmentDTO = null;
		ResponseEntity<Object> appointmentResponse = null;
		appointmentDTO =appointmentService.addAppointment(appointment);
		appointmentResponse = new ResponseEntity<Object>(appointmentDTO, HttpStatus.ACCEPTED);
		return appointmentResponse;
	}
	@GetMapping("/view-appointment/{id}")
	public ResponseEntity getAppointment(@PathVariable int id) {
	
		AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(id);
		
		return new ResponseEntity(appointmentDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-appointments")
	public List<AppointmentDTO> viewAllAppointment() {
		
		return appointmentService.getAllAppointments();
	}
	
	@DeleteMapping("/delete-appointment")
	public ResponseEntity deleteAppointment(@RequestBody AppointmentDTO appointmentdto){
	 appointmentService.deleteAppointment(appointmentdto);
	return new ResponseEntity("deleted successfully:",HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update-appointment")
	public ResponseEntity updateAppointment(@RequestBody AppointmentDTO appointmentdto) {
		appointmentService.updateAppointment(appointmentdto);
		return new ResponseEntity("Updated ", HttpStatus.OK);
		

	}
}
