package com.cg.cars.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cg.cars.exceptions.CardNotFoundException;

@RestController
@RequestMapping("/api/cars")
public class CardController {
	static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);
	@Autowired
	private CardService cardService;

	/************************************************************************************
	 * Method: addCard 
	 * Description: It is used to add Card into Cards table
	 * @param Card: Card's reference variable.
	 * @returns Card: It returns Card with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain  object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping("/add-card")
	public ResponseEntity<Object> insertCard(@RequestBody Card card) {
		LOGGER.info("add-Card URL is opened");
		LOGGER.info("addCard() is initiated");
		CardDTO cardDTO = null;
		ResponseEntity<Object> cardResponse = null;
		cardDTO = cardService.addCard(card);
		cardResponse = new ResponseEntity<>(cardDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addCard() has executed");
		return cardResponse;
	}

	/************************************************************************************
	 * Method: getCardById 
	 * Description: It is used to view Card by id from Cards table
	 * @param Card: Long id
	 * @returns Card: It returns Card with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-card/{id}")
	public ResponseEntity<Object> getCardById(@PathVariable Long id) throws CardNotFoundException {
		LOGGER.info("view-Card URL is opened");
		LOGGER.info("viewCard() is initiated");
		CardDTO cardDTO = cardService.getCardById(id);
		LOGGER.info("viewCard() has executed");
		return new ResponseEntity<>(cardDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllCards 
	 * Description: It is used to view all Cards in Cards table
	 * @returns Card: It returns Card with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@GetMapping("/view-all-card")
	public List<CardDTO> viewAllCard() {
		LOGGER.info("view-all-Card URL is opened");
		LOGGER.info("viewAllCard() is initiated");
		LOGGER.info("viewAllCard() has executed");
		return cardService.getAllCards();
	}

	/************************************************************************************
	 * Method: DeleteCard 
	 * Description: It is used to remove Card from Cards table
	 * @param Card: Long id
	 * @returns Card: It returns Card with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-card/{id}")
	public ResponseEntity<Object> deletePaymentById(@PathVariable Long id) throws CardNotFoundException {
		LOGGER.info("delete-Card URL is opened");
		LOGGER.info("deleteCard() is initiated");
		cardService.deleteCardById(id);
		LOGGER.info("deleteCard() has executed");
		return new ResponseEntity<>("deleted successfully:", HttpStatus.ACCEPTED);
	}

	/************************************************************************************
	 * Method: updateCard 
	 * Description: It is used to update Card into Card table
	 * @param Card: Card's reference variable.
	 * @returns Card: It returns Card with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping("/update-card/{id}")
	public ResponseEntity<Object> updatePayment(@PathVariable Long id, @RequestBody Card cardRequest)
			throws CardNotFoundException {
		LOGGER.info("update-Card URL is opened");
		LOGGER.info("updateCard() is initiated");
		cardService.updateCardById(id, cardRequest);
		LOGGER.info("updateCard() has executed");
		return new ResponseEntity<>("Updated ", HttpStatus.OK);
	}

}
