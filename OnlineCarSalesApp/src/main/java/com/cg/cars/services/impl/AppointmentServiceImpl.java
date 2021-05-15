package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Appointment;
import com.cg.cars.services.AppointmentService;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.repository.AppointmentRepository;
import com.cg.cars.util.AppointmentUtils;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
public AppointmentDTO addAppointment(Appointment appointment) {
	Appointment appointmentEntity=appointmentRepository.save(appointment);
	return AppointmentUtils.convertToAppointmentDto(appointmentEntity);
}


public void deleteAppointment(AppointmentDTO appointmentdto) {
	
	appointmentRepository.delete(AppointmentUtils.convertToAppointment(appointmentdto));
	
}
	
public void updateAppointment(AppointmentDTO appointmentdto) {
	
	appointmentRepository.save(AppointmentUtils.convertToAppointment(appointmentdto));
			
	
}

public AppointmentDTO getAppointmentById(long id) {
	Optional<Appointment> existAppointment=appointmentRepository.findById(id);
	if(existAppointment.isPresent()) {
		Appointment appointment=existAppointment.get();
	return AppointmentUtils.convertToAppointmentDto(appointment);
}
	else {
		return null;
	}
	
}


public List<AppointmentDTO> getAllAppointments(){
		List<Appointment> appointmentList=appointmentRepository.findAll();
		return AppointmentUtils.convertToAppointmentDtoList(appointmentList);
		}
/*public List<Appointment> getOpenAppointments(){
		
	}*/

}


