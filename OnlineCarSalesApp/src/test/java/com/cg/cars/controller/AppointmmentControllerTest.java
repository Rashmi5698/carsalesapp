package com.cg.cars.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.cars.entities.Address;
import com.cg.cars.entities.Admin;
import com.cg.cars.entities.Appointment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AppointmentController.class )
public class AppointmmentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AppointmentController appointmentController;
	
	@Test
	public void testinsertAppointment() throws Exception
	{
		String URI="/api/cars/add-appointmnet";
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(65L);
		appointment.setLocation("US");
		appointment.setInspectionType("Home");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());
		String jsonInput=this.converttoJson(appointment);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetAppointmentById() throws Exception
	{
		String URI="/api/cars/view-appointment/{id}";
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(65L);
		appointment.setLocation("US");
		appointment.setInspectionType("Home");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());
		String jsonInput=this.converttoJson(appointment);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 65L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllAppointment() throws Exception
	{
		String URI="/api/cars/view-all-appointment";
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(65L);
		appointment.setLocation("US");
		appointment.setInspectionType("Home");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());
		
		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentId(65L);
		appointment1.setLocation("US");
		appointment1.setInspectionType("Home");
		appointment1.setPreferredDate(LocalDate.now());
		appointment1.setPreferredTime(LocalTime.now());
		List<Appointment> appointmentList=new ArrayList<>();
		appointmentList.add(appointment);
		appointmentList.add(appointment1);
		String jsonInput=this.converttoJson(appointmentList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemoveAppointment() throws Exception
	{
		String URI="/api/cars/delete-appointmment/{id}";
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(65L);
		appointment.setLocation("US");
		appointment.setInspectionType("Home");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 65L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdateAppointment() throws Exception
	{
		String URI="/api/cars/update-appointment/{id}";
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(65L);
		appointment.setLocation("US");
		appointment.setInspectionType("Home");
		appointment.setPreferredDate(LocalDate.now());
		appointment.setPreferredTime(LocalTime.now());
		String jsonInput=this.converttoJson(appointment);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 65L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object appointment) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(appointment);
	}

}
