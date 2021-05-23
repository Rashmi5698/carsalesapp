package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Appointment;
import com.cg.cars.entities.User;
import com.cg.cars.exceptions.AppointmentNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryTest {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewAppointment() {
		Appointment appointment = getAppointment();
		Appointment saveInDb = testEntityManager.persist(appointment);
		Appointment getFromInDb = appointmentRepository.findById(saveInDb.getAppointmentId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAppointmentById()throws AppointmentNotFoundException {
		Appointment appointment = new Appointment();

		appointment.setLocation("US");
		appointment.setInspectionType("Home");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());

		Appointment saveInDb = testEntityManager.persist(appointment);
		// Get Data from DB
		Appointment getInDb = appointmentRepository.findById(appointment.getAppointmentId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllAppointment() {
		Appointment appointment = new Appointment();

		appointment.setLocation("Uk");
		appointment.setInspectionType("Branch");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());

		Appointment appointment2 = new Appointment();

		appointment2.setLocation("US");
		appointment2.setInspectionType("Home");
		appointment2.setPreferredDate(LocalDate.now());
		appointment2.setPreferredTime(LocalTime.now());
		// Save into in memory database
		testEntityManager.persist(appointment);
		testEntityManager.persist(appointment2);

		// Retrieve all tickets
		List<Appointment> appointmentList = (List<Appointment>) appointmentRepository.findAll();

		Assert.assertEquals(2, appointmentList.size());
	}

	@Test
	public void testDeleteAddressById() throws AppointmentNotFoundException{
		Appointment appointment1 = new Appointment();

		appointment1.setLocation("US");
		appointment1.setInspectionType("Home");
		appointment1.setPreferredDate(LocalDate.now());
		appointment1.setPreferredTime(LocalTime.now());

		Appointment appointment2 = new Appointment();

		appointment2.setLocation("Uk");
		appointment2.setInspectionType("Home");
		appointment2.setPreferredDate(LocalDate.now());
		appointment2.setPreferredTime(LocalTime.now());

		Appointment appointment = testEntityManager.persist(appointment1);
		testEntityManager.persist(appointment2);

		testEntityManager.remove(appointment);

		List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
		Assert.assertEquals(appointments.size(), 1);

	}

	@Test
	public void testUpdateAppointmentById() throws AppointmentNotFoundException {
		Appointment appointment2 = new Appointment();
		appointment2.setLocation("US");
		appointment2.setInspectionType("Home");
		appointment2.setPreferredDate(LocalDate.now());
		appointment2.setPreferredTime(LocalTime.now());

		Appointment saveInDb = testEntityManager.persist(appointment2);

		Appointment getFromDb = appointmentRepository.findById(appointment2.getAppointmentId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Appointment getAppointment() {
		Appointment appointment = new Appointment();
		appointment.setLocation("US");
		appointment.setInspectionType("Home");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());
		return appointment;

	}
}
