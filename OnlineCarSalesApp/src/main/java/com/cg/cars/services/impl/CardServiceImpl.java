package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Card;

import com.cg.cars.model.CardDTO;

import com.cg.cars.services.CardService;
import com.cg.cars.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.CardUtils;


@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardRepository cardRepository;
	
	
public CardDTO addCard(Card card){
	Card cardEntity=cardRepository.save(card);
	return CardUtils.convertToCardDto(cardEntity);
}


public void deleteCard(CardDTO carddto) {
	
	cardRepository.delete(CardUtils.convertToCard(carddto));
	
}
	
public void updateCard(CardDTO carddto) {
	
	cardRepository.save(CardUtils.convertToCard(carddto));
			
	
}

public CardDTO getCardById(String id) {
	Optional<Card> existCard=cardRepository.findById(id);
	if(existCard.isPresent()) {
		Card card=existCard.get();
	return CardUtils.convertToCardDto(card);
}
	else {
		return null;
	}
	
}


public List<CardDTO> getAllCards(){
		List<Card> cardList=cardRepository.findAll();
		return CardUtils.convertToCardDtoList(cardList);
		}
}





