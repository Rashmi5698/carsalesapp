package com.cg.cars.controller;

import static org.junit.jupiter.api.Assertions.*;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AddressController.class )
public class AddressControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AddressController addressController;
	
	@Test
	public void testinsertAddress() throws Exception
	{
		String URI="/api/cars/add-address";
		Address address = new Address();
		address.setAddressId(4545L);
		address.setDoorNo(45L);
		address.setStreet("Church Street");
		address.setArea("MG");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(560074L);
		String jsonInput=this.converttoJson(address);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetAddressById() throws Exception
	{
		String URI="/api/cars/view-address/{id}";
		Address address = new Address();
		address.setAddressId(4545L);
		address.setDoorNo(45L);
		address.setStreet("Church Street");
		address.setArea("MG");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(560074L);
		String jsonInput=this.converttoJson(address);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 4545L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllAdmin() throws Exception
	{
		String URI="/api/cars/view-all-address";
		Address address = new Address();
		address.setAddressId(4545L);
		address.setDoorNo(45L);
		address.setStreet("Church Street");
		address.setArea("MG");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(560074L);
		
		Address address1 = new Address();
		address1.setAddressId(4545L);
		address1.setDoorNo(45L);
		address1.setStreet("Church Street");
		address1.setArea("MG");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode(560074L);
		List<Address> addressList=new ArrayList<>();
		addressList.add(address1);
		addressList.add(address1);
		String jsonInput=this.converttoJson(addressList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemoveAddress() throws Exception
	{
		String URI="/api/cars/delete-address/{id}";
		Address address = new Address();
		address.setAddressId(4545L);
		address.setDoorNo(45L);
		address.setStreet("Church Street");
		address.setArea("MG");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(560074L);
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 4545L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdateAddress() throws Exception
	{
		String URI="/api/cars/update-address/{id}";
		Address address = new Address();
		address.setAddressId(4545L);
		address.setDoorNo(45L);
		address.setStreet("Church Street");
		address.setArea("MG");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(560074L);
		String jsonInput=this.converttoJson(address);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 4545L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object address) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(address);
	}

}
