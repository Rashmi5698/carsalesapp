package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
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




public CardDTO getCardById(Long id) {
	Optional<Card> existCard=cardRepository.findById(id);
	if(existCard.isPresent()) {
		Card card=existCard.get();
	return CardUtils.convertToCardDto(card);
}
	else {
		return null;
	}
	
}
public CardDTO deleteCardById(Long id)throws CardNotFoundException {
	Card Cardexist=cardRepository.findById(id).orElse(null);
	if(Cardexist==null)
		throw new CardNotFoundException("Card with id not present");
	else
		cardRepository.delete(Cardexist);
	return CardUtils.convertToCardDto(Cardexist);
	}



public Card updateCardById(Long id, Card cardRequest) throws CardNotFoundException{
    return cardRepository.findById(id).map( card-> {
    	card.setCardNumber(cardRequest.getCardNumber());
    	card.setCardName(cardRequest.getCardName());
    	card.setCardExpiry(cardRequest.getCardExpiry());
    	card.setCvv(cardRequest.getCvv());
    return cardRepository.save(card);
    }).orElseThrow(()-> new CardNotFoundException("Card with id not present"));
    
}


public List<CardDTO> getAllCards(){
		List<Card> cardList=cardRepository.findAll();
		return CardUtils.convertToCardDtoList(cardList);
		}
}





