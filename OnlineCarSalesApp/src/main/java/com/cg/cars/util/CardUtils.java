package com.cg.cars.util;

import com.cg.cars.model.CardDTO;
import com.cg.cars.entities.Card;
import java.util.List;
import java.util.ArrayList;

public class CardUtils {
	private CardUtils() {
	}
	//converting into screen class
	public static List<CardDTO> convertToCardDtoList(List<Card> list){
		List<CardDTO> dtolist=new ArrayList<CardDTO>();
		for(Card card :list)
			dtolist.add(convertToCardDto(card));
		return dtolist;
}
	
	/*public static Card convertToCard(CardDTO dto) {
		Card card= new Card();
		card.setCardNumber(dto.getCardNumber());
		card.setCardName(dto.getCardName());
		card.setCardExpiry(dto.getCardExpiry());
		card.setCvv(dto.getCvv());
	return card;	
	}*/
	
	public static CardDTO convertToCardDto(Card card ) {
		CardDTO dto=new CardDTO();
		dto.setCardNumber(card.getCardNumber());
		dto.setCardName(card.getCardName());
		dto.setCardExpiry(card.getCardExpiry());
		dto.setCvv(card.getCvv());
	return dto;	
	}
}
