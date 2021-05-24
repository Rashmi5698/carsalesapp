package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Card;
import com.cg.cars.entities.User;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.entities.Card;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CardRepositoryTest {

	@Autowired
	private CardRepository CardRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewCard() {
		Card card = getCard();
		Card saveInDb = testEntityManager.persist(card);
		Card getFromInDb = CardRepository.findById(saveInDb.getCardNumber()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetCardById() throws CardNotFoundException {
		Card card = new Card();

		card.setCardName("hdfc");
		card.setCardExpiry(LocalDate.now());
		card.setCvv(45);
		// Insert Data into in memory database
		Card saveInDb = testEntityManager.persist(card);
		// Get Data from DB
		Card getInDb = CardRepository.findById(card.getCardNumber()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllCards(){
		Card card1 = new Card();

		card1.setCardName("canara");
		card1.setCardExpiry(LocalDate.now());
		card1.setCvv(15);

		Card card2 = new Card();

		card2.setCardName("hdfc");
		card2.setCardExpiry(LocalDate.now());
		card2.setCvv(18);
		// Save into in memory database
		testEntityManager.persist(card1);
		testEntityManager.persist(card2);

		// Retrieve all tickets
		List<Card> cardList = (List<Card>) CardRepository.findAll();

		Assert.assertEquals(2, cardList.size());
	}

	@Test
	public void testDeleteCardById() throws CardNotFoundException {
		Card card1 = new Card();

		card1.setCardName("icici");
		card1.setCardExpiry(LocalDate.now());
		card1.setCvv(25);

		Card card2 = new Card();

		card2.setCardName("state");
		card2.setCardExpiry(LocalDate.now());
		card2.setCvv(55);

		Card card = testEntityManager.persist(card1);
		testEntityManager.persist(card2);

		// delete one ticket DB
		testEntityManager.remove(card);

		List<Card> cards = (List<Card>) CardRepository.findAll();
		Assert.assertEquals(1,cards.size());
	}

	@Test
	public void testUpdateCardById() throws CardNotFoundException{
		Card card2 = new Card();
		card2.setCardName("hdfc");
		card2.setCardExpiry(LocalDate.now());
		card2.setCvv(56);

		Card saveInDb = testEntityManager.persist(card2);

		Card getFromDb = CardRepository.findById(card2.getCardNumber()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Card getCard() {
		Card card1 = new Card();

		card1.setCardName("hdfc");
		card1.setCardExpiry(LocalDate.now());
		card1.setCvv(57);
		return card1;

	}
}
