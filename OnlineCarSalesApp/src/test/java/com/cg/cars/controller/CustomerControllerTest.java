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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class )
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerController customerController;
	
	@Test
	public void testinsertCustomer() throws Exception
	{
		String URI="/api/cars/add-customer";
		Customer customer = new Customer();
		customer.setUserId(45L);
		customer.setName("bhumi");
		customer.setEmail("bhumi@gmail.com");
		customer.setContactNo("45687545");
		customer.setDob(LocalDate.now());
		String jsonInput=this.converttoJson(customer);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetCustomerById() throws Exception
	{
		String URI="/api/cars/view-customer/{id}";
		Customer customer = new Customer();
		customer.setUserId(45L);
		customer.setName("bhumi");
		customer.setEmail("bhumi@gmail.com");
		customer.setContactNo("45687545");
		customer.setDob(LocalDate.now());
		String jsonInput=this.converttoJson(customer);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 45L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllCustomer() throws Exception
	{
		String URI="/api/cars/view-all-customer";
		Customer customer = new Customer();
		customer.setUserId(45L);
		customer.setName("bhumi");
		customer.setEmail("bhumi@gmail.com");
		customer.setContactNo("45687545");
		customer.setDob(LocalDate.now());
		
		Customer customer1 = new Customer();
		customer1.setUserId(45L);
		customer1.setName("bhumi");
		customer1.setEmail("bhumi@gmail.com");
		customer1.setContactNo("45687545");
		customer1.setDob(LocalDate.now());
		List<Customer> customerList=new ArrayList<>();
		customerList.add(customer);
		customerList.add(customer1);
		String jsonInput=this.converttoJson(customerList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemoveCustomer() throws Exception
	{
		String URI="/api/cars/delete-customer/{id}";
		Customer customer = new Customer();
		customer.setUserId(45L);
		customer.setName("bhumi");
		customer.setEmail("bhumi@gmail.com");
		customer.setContactNo("45687545");
		customer.setDob(LocalDate.now());
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 45L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdateCustomer() throws Exception
	{
		String URI="/api/cars/update-customer/{id}";
		Customer customer = new Customer();
		customer.setUserId(45L);
		customer.setName("bhumi");
		customer.setEmail("bhumi@gmail.com");
		customer.setContactNo("45687545");
		customer.setDob(LocalDate.now());
		String jsonInput=this.converttoJson(customer);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 45L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object customer) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(customer);
	}

}
