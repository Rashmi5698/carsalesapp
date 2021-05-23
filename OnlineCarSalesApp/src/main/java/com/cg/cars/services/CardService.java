package com.cg.cars.services;

import java.util.List;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.model.CardDTO;

public interface CardService {

	public CardDTO addCard(Card card);

	public CardDTO getCardById(Long id) throws CardNotFoundException;

	public List<CardDTO> getAllCards();

	public CardDTO deleteCardById(Long id) throws CardNotFoundException;

	public Card updateCardById(Long id, Card CardRequest) throws CardNotFoundException;

}