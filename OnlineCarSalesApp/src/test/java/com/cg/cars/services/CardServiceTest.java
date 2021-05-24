package com.cg.cars.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.model.CardDTO;
import com.cg.cars.repository.CardRepository;
import com.cg.cars.util.CardUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {

	@MockBean
	private CardRepository cardRepo;

	@Autowired
	private CardService cardService;

	@Test
	public void addCardTest() {
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);

		Mockito.when(cardRepo.save(card)).thenReturn(card);
		CardDTO CardDTO = CardUtils.convertToCardDto(card);
		assertEquals(467884L,CardDTO.getCardNumber());
	}

	@Test
	public void showCardByIdTest() throws CardNotFoundException {
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);

		Mockito.when(cardRepo.save(card)).thenReturn(card);
		assertEquals(467884L,card.getCardNumber());
	}

	@Test
	public void showAllCardsTest() throws CardNotFoundException {
		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);

		Card card1 = new Card();
		card1.setCardNumber(4684L);
		card1.setCardName("icici");
		card1.setCardExpiry(LocalDate.now());
		card1.setCvv(45);

		List<Card> cardsList = new ArrayList<>();
		cardsList.add(card);
		cardsList.add(card1);
		Mockito.when(cardRepo.findAll()).thenReturn(cardsList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<CardDTO> dto = CardUtils.convertToCardDtoList(cardsList);
//		System.out.println("after converting:"+dto);
		assertSame(2,cardService.getAllCards().size());
	}

	@Test
	public void deleteCardTest() {
		Card cardOne = new Card();
		cardOne.setCardNumber(467884L);
		cardOne.setCardName("hdfc");
		cardOne.setCardExpiry(LocalDate.now());
		cardOne.setCvv(45);

		Mockito.when(cardRepo.save(cardOne)).thenReturn(cardOne);
		cardRepo.deleteById(cardOne.getCardNumber());
		assertNotEquals(cardOne, new Card());
	}

	@Test
	public void updateCardTest() {

		Card card = new Card();
		card.setCardNumber(467884L);
		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);

		cardRepo.save(card);

		Mockito.when(cardRepo.save(card)).thenReturn(card);
		assertEquals(467884L,card.getCardNumber());
	}

}