package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Card;

import com.cg.cars.model.CardDTO;



public interface CardService {
	
	public CardDTO addCard(Card card);
	
	public CardDTO getCardById(String id);
	
	public List<CardDTO> getAllCards();
	
	public void deleteCard(CardDTO carddto); 
	
	public void updateCard(CardDTO carddto);
	


	
}