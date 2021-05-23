package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Appointment;
import com.cg.cars.exceptions.AppointmentNotFoundException;
import com.cg.cars.services.AppointmentService;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.repository.AppointmentRepository;
import com.cg.cars.util.AppointmentUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	static final Logger LOGGER = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	String appointmentIdNotAvailable = "Appointment with id not present";

	@Autowired
	private AppointmentRepository appointmentRepository;

	public AppointmentDTO addAppointment(Appointment appointment) {
		LOGGER.info("addAppointment() service is initiated");
		Appointment appointmentEntity = appointmentRepository.save(appointment);
		LOGGER.info("addAppointment() service has executed");
		return AppointmentUtils.convertToAppointmentDto(appointmentEntity);
	}

	public AppointmentDTO getAppointmentById(Long id) throws AppointmentNotFoundException {
		LOGGER.info("getAppointment() service is initiated");
		Optional<Appointment> existAppointment = appointmentRepository.findById(id);
		if (existAppointment.isPresent()) {
			Appointment appointment = existAppointment.get();
			LOGGER.info("getAppointment() service has executed");
			return AppointmentUtils.convertToAppointmentDto(appointment);
		} else {
			throw new AppointmentNotFoundException(appointmentIdNotAvailable);
		}

	}

	public List<AppointmentDTO> getAllAppointments() {
		LOGGER.info("getAllAppointment() service is initiated");
		List<Appointment> appointmentList = appointmentRepository.findAll();
		LOGGER.info("getAllAppointment() service has executed");
		return AppointmentUtils.convertToAppointmentDtoList(appointmentList);
	}

	public AppointmentDTO deleteAppointmentById(Long id) throws AppointmentNotFoundException {
		LOGGER.info("deleteAppointment() service is initiated");
		Appointment appointmentexist = appointmentRepository.findById(id).orElse(null);
		if (appointmentexist == null)
			throw new AppointmentNotFoundException(appointmentIdNotAvailable);
		else
			appointmentRepository.delete(appointmentexist);
		LOGGER.info("deleteAppointment() service has executed");
		return AppointmentUtils.convertToAppointmentDto(appointmentexist);
	}

	public Appointment updateAppointmentById(Long id, Appointment appointmentRequest)
			throws AppointmentNotFoundException {
		LOGGER.info("updateAppointment() service is initiated");
		return appointmentRepository.findById(id).map(appointment -> {
			appointment.setLocation(appointmentRequest.getLocation());
			appointment.setInspectionType(appointmentRequest.getInspectionType());
			appointment.setPreferredDate(appointmentRequest.getPreferredDate());
			appointment.setPreferredTime(appointmentRequest.getPreferredTime());
			LOGGER.info("updateAppointment() service has executed");
			return appointmentRepository.save(appointment);
		}).orElseThrow(() -> new AppointmentNotFoundException("Appointment with id not present"));

	}
}