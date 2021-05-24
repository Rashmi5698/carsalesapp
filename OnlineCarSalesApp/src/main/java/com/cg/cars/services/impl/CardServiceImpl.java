package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.model.CardDTO;
import com.cg.cars.services.CardService;
import com.cg.cars.repository.CardRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.CardUtils;

@Service
public class CardServiceImpl implements CardService {
	static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

	@Autowired
	private CardRepository cardRepository;

	public CardDTO addCard(Card card) {
		LOGGER.info("addCard() service is initiated");
		Card cardEntity = cardRepository.save(card);
		LOGGER.info("addCard() service has executed");
		return CardUtils.convertToCardDto(cardEntity);
	}

	public CardDTO getCardById(Long id) {
		LOGGER.info("getByIdCard() service is initiated");
		Optional<Card> existCard = cardRepository.findById(id);
		if (existCard.isPresent()) {
			Card card = existCard.get();
			LOGGER.info("getByIdCard() service has executed");
			return CardUtils.convertToCardDto(card);
		} else {
			return null;
		}

	}

	public CardDTO deleteCardById(Long id) throws CardNotFoundException {
		LOGGER.info("deleteCard() service is initiated");
		Card cardexist = cardRepository.findById(id).orElse(null);
		if (cardexist == null)
			throw new CardNotFoundException("Card with id not present");
		else
			cardRepository.delete(cardexist);
		LOGGER.info("deleteCard() service has executed");
		return CardUtils.convertToCardDto(cardexist);
	}

	public Card updateCardById(Long id, Card cardRequest) throws CardNotFoundException {
		LOGGER.info("updateCard() service is initiated");
		return cardRepository.findById(id).map(card -> {
			card.setCardNumber(cardRequest.getCardNumber());
			card.setCardName(cardRequest.getCardName());
			card.setCardExpiry(cardRequest.getCardExpiry());
			LOGGER.info("updateCard() service has executed");
			card.setCvv(cardRequest.getCvv());
			return cardRepository.save(card);
		}).orElseThrow(() -> new CardNotFoundException("Card with id not present"));

	}

	public List<CardDTO> getAllCards() {
		LOGGER.info("getallCard() service is initiated");
		List<Card> cardList = cardRepository.findAll();
		LOGGER.info("getAllCard() service has executed");
		return CardUtils.convertToCardDtoList(cardList);
	}
}
