package com.cg.cars.services;

import java.util.List;
import com.cg.cars.model.AppointmentDTO;

import com.cg.cars.entities.Appointment;

public interface AppointmentService {
	
	public AppointmentDTO addAppointment(Appointment appointment);
	
	public List<AppointmentDTO> getAllAppointments(); 
	
	public void deleteAppointment(AppointmentDTO appointmentdto); 
	
	public void updateAppointment(AppointmentDTO appointmentdto);
	
	public AppointmentDTO getAppointmentById(long id);
	
	//public AppointmentDTO removeAppointmentById(long id); 
	
	//public Appointment updateAppointmentById(long id, Appointment appointment);
	
	//public List<Appointment> getOpenAppointments();
	

}
