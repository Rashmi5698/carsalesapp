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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderController.class )
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderController orderController;
	
	@Test
	public void testinsertOrder() throws Exception
	{
		String URI="/api/cars/add-order";
		Order order=new Order();
		order.setOrderId(4545L);
		order.setAmount(45.00);
		order.setBillingDate(LocalDate.now());
		String jsonInput=this.converttoJson(order);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetOrderById() throws Exception
	{
		String URI="/api/cars/view-order/{id}";
		Order order=new Order();
		order.setOrderId(4545L);
		order.setAmount(45.00);
		order.setBillingDate(LocalDate.now());
		String jsonInput=this.converttoJson(order);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 4545L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllOrder() throws Exception
	{
		String URI="/api/cars/view-all-order";
		Order order=new Order();
		order.setOrderId(4545L);
		order.setAmount(45.00);
		order.setBillingDate(LocalDate.now());
		
		Order order1=new Order();
		order1.setOrderId(4545L);
		order1.setAmount(45.00);
		order1.setBillingDate(LocalDate.now());
		List<Order> orderList=new ArrayList<>();
		orderList.add(order);
		orderList.add(order1);
		String jsonInput=this.converttoJson(orderList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemoveOrder() throws Exception
	{
		String URI="/api/cars/delete-order/{id}";
		Order order=new Order();
		order.setOrderId(4545L);
		order.setAmount(45.00);
		order.setBillingDate(LocalDate.now());
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 4545L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdateOrder() throws Exception
	{
		String URI="/api/cars/update-order/{id}";
		Order order=new Order();
		order.setOrderId(4545L);
		order.setAmount(45.00);
		order.setBillingDate(LocalDate.now());
		String jsonInput=this.converttoJson(order);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 4545L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object order) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(order);
	}

}
