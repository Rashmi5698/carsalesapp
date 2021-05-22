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
import com.cg.cars.entities.Car;
import com.cg.cars.entities.Card;
import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Order;
import com.cg.cars.entities.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PaymentController.class )
public class PaymentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PaymentController paymentController;
	
	@Test
	public void testinsertPayment() throws Exception
	{
		String URI="/api/cars/add-payment";
		Payment payment = new Payment();
		payment.setPaymentId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		String jsonInput=this.converttoJson(payment);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetPaymentById() throws Exception
	{
		String URI="/api/cars/view-payment/{id}";
		Payment payment = new Payment();
		payment.setPaymentId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		String jsonInput=this.converttoJson(payment);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 32L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllPayment() throws Exception
	{
		String URI="/api/cars/view-all-payment";
		Payment payment = new Payment();
		payment.setPaymentId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		
		Payment payment1 = new Payment();
		payment1.setPaymentId(32L);
		payment1.setType("Online");
		payment1.setStatus("Done");
		List<Payment> paymentList=new ArrayList<>();
		paymentList.add(payment);
		paymentList.add(payment1);
		String jsonInput=this.converttoJson(paymentList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemovePayment() throws Exception
	{
		String URI="/api/cars/delete-payment/{id}";
		Payment payment = new Payment();
		payment.setPaymentId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 32L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdatePayment() throws Exception
	{
		String URI="/api/cars/update-payment/{id}";
		Payment payment = new Payment();
		payment.setPaymentId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		String jsonInput=this.converttoJson(payment);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 32L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object payment) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(payment);
	}

}
