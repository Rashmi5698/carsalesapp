package com.cg.cars.services.impl;


import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Appointment;
import com.cg.cars.exceptions.AppointmentNotFoundException;
import com.cg.cars.services.AppointmentService;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.repository.AppointmentRepository;
import com.cg.cars.util.AppointmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppointmentServiceImpl implements AppointmentService{
	String appointmentIdNotAvailable="Appointment with id not present";
	
		@Autowired
	    private AppointmentRepository appointmentRepository;

		public AppointmentDTO addAppointment(Appointment appointment){
			Appointment appointmentEntity=appointmentRepository.save(appointment);
			return AppointmentUtils.convertToAppointmentDto(appointmentEntity);
		}
	public AppointmentDTO getAppointmentById(Long id) throws AppointmentNotFoundException {
		Optional<Appointment> existAppointment=appointmentRepository.findById(id);
		if(existAppointment.isPresent()) {
			Appointment appointment=existAppointment.get();
		return AppointmentUtils.convertToAppointmentDto(appointment);
	}
		else {
			throw new AppointmentNotFoundException(appointmentIdNotAvailable); 
		}
		
	}
	
	public List<AppointmentDTO> getAllAppointments(){
			List<Appointment> appointmentList=appointmentRepository.findAll();
			return AppointmentUtils.convertToAppointmentDtoList(appointmentList);
			}
	
	public AppointmentDTO deleteAppointmentById(Long id)throws AppointmentNotFoundException {
		Appointment appointmentexist=appointmentRepository.findById(id).orElse(null);
		if(appointmentexist==null)
			throw new AppointmentNotFoundException(appointmentIdNotAvailable);
		else
			appointmentRepository.delete(appointmentexist);
		return AppointmentUtils.convertToAppointmentDto(appointmentexist);
	}  
	public Appointment updateAppointmentById(Long id, Appointment appointmentRequest) throws AppointmentNotFoundException{
	    return appointmentRepository.findById(id).map( appointment-> {
	    	appointment.setLocation(appointmentRequest.getLocation());
	    	appointment.setInspectionType(appointmentRequest.getInspectionType());
	    	appointment.setPreferredDate(appointmentRequest.getPreferredDate());
	    	appointment.setPreferredTime(appointmentRequest.getPreferredTime());
	    	
	    return appointmentRepository.save(appointment);
	    }).orElseThrow(()-> new AppointmentNotFoundException("Appointment with id not present"));
	    
	}
	}