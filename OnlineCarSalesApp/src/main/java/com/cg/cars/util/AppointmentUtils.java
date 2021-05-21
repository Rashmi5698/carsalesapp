package com.cg.cars.util;

import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.entities.Appointment;
import java.util.List;
import java.util.ArrayList;

public class AppointmentUtils {
	private AppointmentUtils() {
	}
	//converting into screen class
	public static List<AppointmentDTO> convertToAppointmentDtoList(List<Appointment> list){
		List<AppointmentDTO> dtolist=new ArrayList<AppointmentDTO>();
		for(Appointment appointment :list)
			dtolist.add(convertToAppointmentDto(appointment));
		return dtolist;
}
	
	public static Appointment convertToAppointment(AppointmentDTO dto) {
		Appointment appointment= new Appointment();
		appointment.setAppointmentId(dto.getAppointmentId());
		appointment.setLocation(dto.getLocation());
		appointment.setInspectionType(dto.getInspectionType());
		appointment.setPreferredDate(dto.getPreferredDate());
		appointment.setPreferredTime(dto.getPreferredTime());
		appointment.setPayment(dto.getPayment());
		
	return appointment;	
	}
	
	public static AppointmentDTO convertToAppointmentDto(Appointment appointment ) {
		AppointmentDTO dto=new AppointmentDTO();
		dto.setAppointmentId(appointment.getAppointmentId());
		dto.setLocation(appointment.getLocation());
		dto.setInspectionType(appointment.getInspectionType());
		dto.setPreferredDate(appointment.getPreferredDate());
		dto.setPreferredTime(appointment.getPreferredTime());
		dto.setPayment(appointment.getPayment());
		
	return dto;	
	}
}
