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
import com.cg.cars.entities.Card;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardController.class )
public class CardControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CardController cardController;
	
	@Test
	public void testinsertCard() throws Exception
	{
		String URI="/api/cars/add-card";
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);
		String jsonInput=this.converttoJson(card);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetCardById() throws Exception
	{
		String URI="/api/cars/view-card/{id}";
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);
		String jsonInput=this.converttoJson(card);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 467884L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllCard() throws Exception
	{
		String URI="/api/cars/view-all-card";
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);
		
		Card card1 = new Card();
		card1.setCardNumber(467884L);
		card1.setCardName("hdfc");
		card1.setCardExpiry(LocalDate.now());
		card1.setCvv(45);
		List<Card> cardList=new ArrayList<>();
		cardList.add(card);
		cardList.add(card1);
		String jsonInput=this.converttoJson(cardList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemoveCard() throws Exception
	{
		String URI="/api/cars/delete-card/{id}";
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 467884L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdateCard() throws Exception
	{
		String URI="/api/cars/update-card/{id}";
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);
		String jsonInput=this.converttoJson(card);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 467884L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object card) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(card);
	}

}
