package com.cg.cars.util;

import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.entities.Appointment;
import java.util.List;
import java.util.ArrayList;

public class AppointmentUtils {
	private AppointmentUtils() {
	}

	public static List<AppointmentDTO> convertToAppointmentDtoList(List<Appointment> list) {
		List<AppointmentDTO> dtolist = new ArrayList<>();
		for (Appointment appointment : list)
			dtolist.add(convertToAppointmentDto(appointment));
		return dtolist;
	}

	public static AppointmentDTO convertToAppointmentDto(Appointment appointment) {
		AppointmentDTO dto = new AppointmentDTO();
		dto.setAppointmentId(appointment.getAppointmentId());
		dto.setLocation(appointment.getLocation());
		dto.setInspectionType(appointment.getInspectionType());
		dto.setPreferredDate(appointment.getPreferredDate());
		dto.setPreferredTime(appointment.getPreferredTime());
		dto.setPayment(appointment.getPayment());

		return dto;
	}
}
