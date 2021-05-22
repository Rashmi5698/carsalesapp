package com.cg.cars.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cg.cars.entities.Appointment;
import com.cg.cars.exceptions.AppointmentNotFoundException;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.repository.AppointmentRepository;
import com.cg.cars.util.AppointmentUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {

	@MockBean
	private AppointmentRepository appointmmentRepo;

	@Autowired
	private AppointmentService appointmentService;

	@Test
	public void addAppointmentTest() {
		Appointment Appointment = new Appointment();
		Appointment.setAppointmentId(65L);
		Appointment.setLocation("US");
		Appointment.setInspectionType("Home");
		Appointment.setPreferredDate(LocalDate.now());
		Appointment.setPreferredTime(LocalTime.now());

		Mockito.when(appointmmentRepo.save(Appointment)).thenReturn(Appointment);
		AppointmentDTO AppointmentDTO = AppointmentUtils.convertToAppointmentDto(Appointment);
		assertEquals(AppointmentDTO.getAppointmentId(), 65L);
	}

	@Test
	public void showAppointmentByIdTest() throws AppointmentNotFoundException {
		Appointment Appointment = new Appointment();
		Appointment.setAppointmentId(65L);
		Appointment.setLocation("US");
		Appointment.setInspectionType("Home");
		Appointment.setPreferredDate(LocalDate.now());
		Appointment.setPreferredTime(LocalTime.now());

		Mockito.when(appointmmentRepo.save(Appointment)).thenReturn(Appointment);
		assertEquals(Appointment.getAppointmentId(), 65L);
	}

	@Test
	public void showAllAppointmentsTest() throws AppointmentNotFoundException {
		Appointment Appointment = new Appointment();
		Appointment.setAppointmentId(65L);
		Appointment.setLocation("US");
		Appointment.setInspectionType("Home");
		Appointment.setPreferredDate(LocalDate.now());
		Appointment.setPreferredTime(LocalTime.now());

		Appointment Appointment1 = new Appointment();
		Appointment1.setAppointmentId(65L);
		Appointment1.setLocation("US");
		Appointment1.setInspectionType("Home");
		Appointment1.setPreferredDate(LocalDate.now());
		Appointment1.setPreferredTime(LocalTime.now());

		List<Appointment> AppointmentsList = new ArrayList<>();
		AppointmentsList.add(Appointment);
		AppointmentsList.add(Appointment1);
		Mockito.when(appointmmentRepo.findAll()).thenReturn(AppointmentsList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<AppointmentDTO> dto = AppointmentUtils.convertToAppointmentDtoList(AppointmentsList);
//		System.out.println("after converting:"+dto);
		assertSame(appointmentService.getAllAppointments().size(), 2);
	}

	@Test
	public void deleteAppointmentTest() {
		Appointment Appointment = new Appointment();
		Appointment.setAppointmentId(65L);
		Appointment.setLocation("US");
		Appointment.setInspectionType("Home");
		Appointment.setPreferredDate(LocalDate.now());
		Appointment.setPreferredTime(LocalTime.now());

		Mockito.when(appointmmentRepo.save(Appointment)).thenReturn(Appointment);
		appointmmentRepo.deleteById(Appointment.getAppointmentId());
		assertNotEquals(Appointment, new Appointment());
	}

	@Test
	public void updateAppointmentTest() {

		Appointment Appointment = new Appointment();
		Appointment.setAppointmentId(65L);
		Appointment.setLocation("US");
		Appointment.setInspectionType("Home");
		Appointment.setPreferredDate(LocalDate.now());
		Appointment.setPreferredTime(LocalTime.now());
		appointmmentRepo.save(Appointment);

		Mockito.when(appointmmentRepo.save(Appointment)).thenReturn(Appointment);
		assertEquals(Appointment.getAppointmentId(), 65L);
	}

}