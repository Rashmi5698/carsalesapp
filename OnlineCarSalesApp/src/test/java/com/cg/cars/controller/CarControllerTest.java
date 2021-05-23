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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CarController.class )
public class CarControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarController carController;
	
	@Test
	public void testinsertCar() throws Exception
	{
		String URI="/api/cars/add-car";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		String jsonInput=this.converttoJson(car);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetCarById() throws Exception
	{
		String URI="/api/cars/view-car/{id}";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		String jsonInput=this.converttoJson(car);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 4545L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllCar() throws Exception
	{
		String URI="/api/cars/view-all-car";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		
		Car car1 = new Car();
		car1.setCarId(4545L);
		car1.setBrand("Bugatii");
		car1.setModel("New");
		car1.setVariant("yes");
		car1.setRegistrationYear(LocalDate.now());
		car1.setRegistrationState("Bangalore");
		List<Car> carList=new ArrayList<>();
		carList.add(car);
		carList.add(car1);
		String jsonInput=this.converttoJson(carList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemoveCar() throws Exception
	{
		String URI="/api/cars/delete-car/{id}";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 4545L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdateCard() throws Exception
	{
		String URI="/api/cars/update-car/{id}";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		String jsonInput=this.converttoJson(car);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 4545L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	@Test
	public void testFindCarByModel() throws Exception
	{
		String URI="/api/cars/view-car-byModel/{model:.+}";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		String jsonInput=this.converttoJson(car);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI,"New").accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	@Test
	public void testFindCarByBrand() throws Exception
	{
		String URI="/api/cars/view-car-byBrand/{brand:.+}";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		String jsonInput=this.converttoJson(car);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI,"Bugatii").accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	@Test
	public void testFindCarByLocation() throws Exception
	{
		String URI="/api/cars/view-car-bylocation/{location:.+}";
		Car car = new Car();
		car.setCarId(4545L);
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		String jsonInput=this.converttoJson(car);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI,"Bangalore").accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object car) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(car);
	}

}
