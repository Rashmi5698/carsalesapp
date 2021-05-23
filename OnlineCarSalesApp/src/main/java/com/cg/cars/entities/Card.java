package com.cg.cars.entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "Card")
public class Card {
	@Id
	@Column(name = "CARD_NUMBER")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardNumber;

	@Column(name = "CARD_NAME")
	private String cardName;
	@Column(name = "CARD_EXPIRY")
	private LocalDate cardExpiry;
	@Column(name = "CVV")
	private Integer cvv;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

}
