package com.cg.cars.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cg.cars.exceptions.AppointmentNotFoundException;

@RestController
@RequestMapping("/api/cars")
public class AppointmentController {
	static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	@Autowired
	private AppointmentService appointmentService;

	/************************************************************************************
	 * Method: addAppointment 
	 * Description: It is used to add Appointment into Appointments table
	 * @param Appointment: Appointment's reference variable.
	 * @returns Appointment: It returns Appointment with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@PostMapping("/add-appointment")
	public ResponseEntity<Object> insertAppointment(@RequestBody Appointment appointment) {
		LOGGER.info("add-Appointment URL is opened");
		LOGGER.info("addAppointment() is initiated");
		AppointmentDTO appointmentDTO = null;
		ResponseEntity<Object> appointmentResponse = null;
		appointmentDTO = appointmentService.addAppointment(appointment);
		appointmentResponse = new ResponseEntity<>(appointmentDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addAppointment() has executed");
		return appointmentResponse;
	}

	/************************************************************************************
	 * Method: getAppointmentById 
	 * Description: It is used to view Appointment by id from Appointments table
	 * @param Appointment: Long id
	 * @returns Appointment: It returns Appointment with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-appointment/{id}")
	public ResponseEntity<Object> getAppointment(@PathVariable Long id) throws AppointmentNotFoundException {
		LOGGER.info("view-Appointment URL is opened");
		LOGGER.info("viewAppointment() is initiated");
		AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(id);
		LOGGER.info("viewAppointment() has executed");
		return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllAppointments 
	 * Description: It is used to view all Appointments in Appointments table
	 * @returns Appointment: It returns Appointment with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@GetMapping("/view-all-appointments")
	public List<AppointmentDTO> viewAllAppointment() {
		LOGGER.info("view-all-Appointment URL is opened");
		LOGGER.info("viewAllAppointment() is initiated");
		LOGGER.info("viewAllAppointment() has executed");
		return appointmentService.getAllAppointments();
	}

	/************************************************************************************
	 * Method: DeleteAppointment 
	 * Description: It is used to remove Appointment from Appointments table
	 * @param Appointment: Long id
	 * @returns Appointment: It returns Appointment with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-appointment/{id}")
	public ResponseEntity<Object> deleteAppointmentById(@PathVariable Long id) throws AppointmentNotFoundException {
		LOGGER.info("delete-Appointment URL is opened");
		LOGGER.info("deleteAppointment() is initiated");
		appointmentService.deleteAppointmentById(id);
		LOGGER.info("deleteAppointment() has executed");
		return new ResponseEntity<>("deleted successfully:", HttpStatus.ACCEPTED);

	}

	/************************************************************************************
	 * Method: updateAppointment 
	 * Description: It is used to update Appointment into Appointment table
	 * @param Appointment: Appointment's reference variable.
	 * @returns Appointment It returns Appointment with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping("/update-appointment/{id}")

	public ResponseEntity<Object> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentRequest)
			throws AppointmentNotFoundException {
		LOGGER.info("update-Appointment URL is opened");
		LOGGER.info("updateAppointment() is initiated");
		appointmentService.updateAppointmentById(id, appointmentRequest);
		LOGGER.info("updateAppointment() has executed");
		return new ResponseEntity<>("Updated ", HttpStatus.OK);
	}

}
