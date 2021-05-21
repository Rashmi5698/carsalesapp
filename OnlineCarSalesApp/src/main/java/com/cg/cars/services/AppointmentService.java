package com.cg.cars.services;



import java.util.List;
import com.cg.cars.exceptions.AppointmentNotFoundException;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.entities.Appointment;

public interface AppointmentService {
	
	
	public AppointmentDTO addAppointment(Appointment appointment);
	
	public AppointmentDTO getAppointmentById(Long id) throws AppointmentNotFoundException;
		
		public List<AppointmentDTO> getAllAppointments();
		
		public AppointmentDTO deleteAppointmentById(Long id)throws AppointmentNotFoundException; 
		
		public Appointment updateAppointmentById(Long id, Appointment appointmentRequest) throws AppointmentNotFoundException;
	
	
	
}
