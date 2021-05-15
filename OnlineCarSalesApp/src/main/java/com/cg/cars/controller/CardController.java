package com.cg.cars.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.services.CardService;

import com.cg.cars.model.CardDTO;

import com.cg.cars.entities.Card;


//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class CardController {
	
	@Autowired
	private CardService cardService;
	@PostMapping("/add-card")
	public ResponseEntity<Object> insertCard(@RequestBody Card card)
	{
		CardDTO cardDTO = null;
		ResponseEntity<Object> cardResponse = null;
		cardDTO =cardService.addCard(card);
		cardResponse = new ResponseEntity<Object>(cardDTO, HttpStatus.ACCEPTED);
		return cardResponse;
	}
	@GetMapping("/view-card/{id}")
	public ResponseEntity getCardById(@PathVariable String id) {
	
		CardDTO addressDTO = cardService.getCardById(id);
		
		return new ResponseEntity(addressDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-card")
	public List<CardDTO> viewAllCard() {
		
		return cardService.getAllCards();
	}
	
	@DeleteMapping("/delete-card")
	public ResponseEntity deleteCard(@RequestBody CardDTO carddto){
	 cardService.deleteCard(carddto);
	return new ResponseEntity("deleted successfully:",HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update-card")
	public ResponseEntity updateCard(@RequestBody CardDTO carddto) {
		cardService.updateCard(carddto);
		return new ResponseEntity("Updated ", HttpStatus.OK);
		

	}
	

}
