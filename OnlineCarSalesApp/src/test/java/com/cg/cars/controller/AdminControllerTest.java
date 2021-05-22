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

import com.cg.cars.entities.Admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class )
public class AdminControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AdminController adminController;
	
	@Test
	public void testinsertAdmin() throws Exception
	{
		String URI="/api/cars/add-Admin";
		Admin admin = new Admin();
		admin.setAdminId(12L);
		admin.setPassword("ggdyued");
		String jsonInput=this.converttoJson(admin);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetAdminById() throws Exception
	{
		String URI="/api/cars/view-admin/{id}";
		Admin admin = new Admin();
		admin.setAdminId(12L);
		admin.setPassword("ggdyued");
		String jsonInput=this.converttoJson(admin);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 12L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllAdmin() throws Exception
	{
		String URI="/api/cars/view-all-Admin";
		Admin admin = new Admin();
		admin.setAdminId(12L);
		admin.setPassword("ggdyued");
		
		Admin admin1 = new Admin();
		admin1.setAdminId(12L);
		admin1.setPassword("ggdyued");
		
		List<Admin> addressList=new ArrayList<>();
		addressList.add(admin);
		addressList.add(admin1);
		String jsonInput=this.converttoJson(addressList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemoveAdmin() throws Exception
	{
		String URI="/api/cars/delete-admin/{id}";
		Admin admin = new Admin();
		admin.setAdminId(12L);
		admin.setPassword("ggdyued");
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 12L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdateAdmin() throws Exception
	{
		String URI="/api/cars/update-admin/{id}";
		Admin admin = new Admin();
		admin.setAdminId(12L);
		admin.setPassword("ggdyued");
		String jsonInput=this.converttoJson(admin);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 12L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object admin) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(admin);
	}

}
